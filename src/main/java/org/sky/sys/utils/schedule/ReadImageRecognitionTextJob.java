package org.sky.sys.utils.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
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
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.txsb.client.TbStTxsbMapper;
import org.sky.txsb.model.TbStTxsb;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;

/**
 * 
 * @ClassName:  ImageRecognitionJob   
 * @Description:TODO(读取图像识别结果计划任务)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:13:04   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class ReadImageRecognitionTextJob implements Job {
	private final Logger logger=Logger.getLogger(ImageRecognitionJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStTxsbMapper txsbMapper = BspUtils.getBean(TbStTxsbMapper.class);
		String dir = ConfUtils.getValue("IMG_RESULT_TEXT");
		File dirFile = new File(dir);
		File[] textFiles = dirFile.listFiles();
		if(null!=textFiles&&textFiles.length>0) {
			try {
				for(File text:textFiles) {
					BufferedReader br = new BufferedReader(new FileReader(text));//构造一个BufferedReader类来读取文件
				    String res = null;
				    while((res = br.readLine())!=null){//使用readLine方法，一次读一行
				        //System.out.println(s);
				    	if(!StringUtils.isNull(res)) {
				    		String[] resList = res.split(" ");
				    		TbStTxsb sb = new TbStTxsb();
				    		sb.setId(CommonUtils.getUUID(32));
				    		sb.setXsd(new BigDecimal(resList[0]));
				    		sb.setAjbh(resList[1].split("_")[0]);
				    		sb.setAjtxxh(new Integer(resList[1].split("_")[1].substring(0, 1)));
				    		sb.setYwbh(resList[2].split("_")[0]);
				    		String ywlx="";
				    		if(resList[2].split("_")[0].startsWith("X")) {
				    			ywlx="XSXX";
				    		}else {
				    			ywlx="SJZQ";
				    		}
				    		sb.setYwlx(ywlx);
				    		sb.setTxxh(new Integer(resList[2].split("_")[1].substring(0, 1)));
				    		sb.setWz(resList[3]+" "+resList[4]+" "+resList[5]+" "+resList[6]);
				    		sb.setSbsj(CommonUtils.getCurrentDbDate());
				    		txsbMapper.insertSelective(sb);
				    	}
				    }
				    br.close();
				    text.deleteOnExit();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
}