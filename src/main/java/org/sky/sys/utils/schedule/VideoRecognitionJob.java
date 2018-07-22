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
import org.sky.spsb.client.TbStSpTxMapper;
import org.sky.spsb.model.TbStSpTx;
import org.sky.spsb.model.TbStSpTxExample;
import org.sky.spsb.model.TbStSpTxWithBLOBs;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;

/**
 * 
 * @ClassName:  VideoRecognitionJob   
 * @Description:TODO(视频识别计划任务)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:13:04   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class VideoRecognitionJob implements Job {
	private final Logger logger=Logger.getLogger(VideoRecognitionJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		//视频图像信息
		TbStSpTxMapper sptxMapper = BspUtils.getBean(TbStSpTxMapper.class);
		TbStSpTxExample sptxe = new TbStSpTxExample();
		Map filter  = new HashMap();
		filter.put("zt@=","0");
		sptxe.integratedQuery(filter);
		sptxe.setOrderByClause(" create_time desc ");
		//查询没用匹配过的图像
		List<TbStSpTxWithBLOBs> list = sptxMapper.selectByExampleWithBLOBs(sptxe);
		Map<String,List> ywMaps = new HashMap();
		for(TbStSpTxWithBLOBs tx:list) {
			exeVideoRecognition(tx);
		}
	}
	/**
	 * 执行匹配
	 * @param tx
	 */
	private void exeVideoRecognition(TbStSpTxWithBLOBs sptx) {
		//图片存放目录
		String dir = ConfUtils.getValue("TXTASK_DIR")+sptx.getSpbh();
		File dirFile = new File(dir);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		String[] splits = sptx.getWjmc().split("\\.");
		String filepath = dir+File.separator+sptx.getId()+"."+splits[splits.length-1];
		File f = new File(filepath);
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		try {
			Base64Img.GenerateImage(sptx.getTxnr(), filepath);
			String path=ConfUtils.getValue("EXE");
			String[] cmd = {path,"5",dir,sptx.getSplj()};
			System.out.println("**************************");
			System.out.println(dir);
			System.out.println(sptx.getSplj());
			System.out.println("**************************");
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
			logger.info("调用："+sptx.getId());
			//break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
