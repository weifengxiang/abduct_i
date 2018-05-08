package org.sky.sys.utils.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;

/**
 * 
 * @ClassName:  ImageRecognitionJob   
 * @Description:TODO(图像识别计划任务)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:13:04   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class ImageRecognitionJob implements Job {
	private final Logger logger=Logger.getLogger(ImageRecognitionJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStTxxxMapper txxxMapper = BspUtils.getBean(TbStTxxxMapper.class);
		TbStTxxxExample txxxe = new TbStTxxxExample();
		Map filter  = new HashMap();
		filter.put("ywlx@in","SJZQ,XSXX");
		filter.put("not exists(select 1 from tb_st_txsb tx where tx.ywbh=tb_st_txxx.ywbh) and 1@=",1);
		txxxe.integratedQuery(filter);
		txxxe.setOrderByClause(" create_time desc ");
		//查询没用匹配过的图像
		List<TbStTxxx> list = txxxMapper.selectByExampleWithBLOBs(txxxe);
		Map<String,List> ywMaps = new HashMap();
		for(TbStTxxx tx:list) {
			if(ywMaps.containsKey(tx.getYwbh())) {
				ywMaps.get(tx.getYwbh()).add(tx);
			}else {
				List temp = new ArrayList();
				temp.add(tx);
				ywMaps.put(tx.getYwbh(), temp);
			}
		}
		if(!ywMaps.isEmpty()) {
			Iterator it = ywMaps.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>)it.next();
				List temp =(List) entry.getValue();
				exeImageRecognition(temp);
			}
			
		}
	}
	/**
	 * 执行匹配
	 * @param tx
	 */
	private void exeImageRecognition(List<TbStTxxx> txList) {
		for(TbStTxxx tx:txList) {
			if(!tx.getYwlx().equals("XSXX")) {
				return;
			}
			String dir = ConfUtils.getValue("TXTASK_DIR")+tx.getYwbh();
			File dirFile = new File(dir);
			if(!dirFile.exists()) {
				dirFile.mkdirs();
			}
			String filepath = dir+File.separator+tx.getYwbh()+"_"+tx.getSeq()+"."+tx.getTxlx();
			File f = new File(filepath);
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			try {
				Base64Img.GenerateImage(tx.getTxnr(), filepath);
				String path=ConfUtils.getValue("EXE");
				String[] cmd = {path,"4",dir};
				ProcessBuilder pb = new ProcessBuilder(cmd);
				try {
					Process proc = pb.start();
					//如果不读取返回值,exe会卡主
					StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "Error");            
		            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "Output");
		            errorGobbler.start();
		            outputGobbler.start();
		            //调用waitfor会等待执行完成后再执行下一个
		            proc.waitFor();
					//Thread.sleep(10000);  // 打开程序的时间
					//pro.destroyForcibly();  //程序打开后将cmd关闭
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				logger.info("调用："+tx.getYwbh());
				//break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}

class StreamGobbler extends Thread {
	InputStream is;
	String type;
	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (type.equals("Error")) {
					// LogManager.logError(line);
				} else {
					// LogManager.logDebug(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}