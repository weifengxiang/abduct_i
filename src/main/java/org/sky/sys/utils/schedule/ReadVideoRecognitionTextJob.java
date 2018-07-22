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
import org.sky.msg.client.TbStMsgMapper;
import org.sky.spsb.client.TbStSpTxMapper;
import org.sky.spsb.model.TbStSpTxExample;
import org.sky.spsb.model.TbStSpTxWithBLOBs;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.txsb.client.TbStTxsbMapper;
import org.sky.txsb.model.TbStTxsb;
import org.sky.txsb.model.TbStTxsbExample;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @ClassName:  ReadVideoRecognitionTextJob   
 * @Description:TODO(读取视频识别结果计划任务)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:13:04   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class ReadVideoRecognitionTextJob implements Job {
	private final Logger logger=Logger.getLogger(ReadVideoRecognitionTextJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStTxsbMapper txsbMapper = BspUtils.getBean(TbStTxsbMapper.class);
		TbStMsgMapper msgMapper = BspUtils.getBean(TbStMsgMapper.class);
		TbStSpTxMapper spxtMapper = BspUtils.getBean(TbStSpTxMapper.class);
		String dir = ConfUtils.getValue("VIDEO_RESULT_TEXT");
		//0.99 14586fd2475cfba9453f35d357de1d68.jpg V3701000000002018070001_9504_2018722172134356.jpg 606 344 105 155
		String resFormat="相似度 图片名称 视频截图 位置";
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
				    		String resArray[] = res.split(" ");
				    		String xsd = resArray[0];//相似度
				    		String txid = resArray[1].split("\\.")[0];//图片ID
				    		String spbh = resArray[2].split("_")[0];//视频编号
				    		String spmc = resArray[2].split("_")[1];//视频名称
				    		String filePath = ConfUtils.getValue("VIDEO_RESULT_IMG")+File.separator+resArray[2];//视频路径
				    		System.out.println("filePath:"+filePath);
				    		TbStSpTxWithBLOBs bean = spxtMapper.selectByPrimaryKey(txid);
				    		if(null!=bean) {
				    			bean.setSpwjmc(spmc);
				    			bean.setJt("data:image/jpeg;base64,"+Base64Img.GetImageStr(filePath));
				    			bean.setXsd(new BigDecimal(xsd));
				    			bean.setZt("1");
				    			spxtMapper.updateByPrimaryKeySelective(bean);
				    		}
				    	}
					    break;
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
	public static void main(String[] args) {
		String res = "0.99 14586fd2475cfba9453f35d357de1d68.jpg V3701000000002018070001_9504_2018722172134356.jpg 606 344 105 155";
		String resArray[] = res.split(" ");
		String xsd = resArray[0];//相似度
		String txid = resArray[1].split("\\.")[0];//图片ID
		String spbh = resArray[2].split("_")[0];//视频编号
		String spmc = resArray[2].split("_")[1];//视频名称
		String filePath = ConfUtils.getValue("VIDEO_RESULT_IMG")+File.separator+resArray[2];//视频路径
		System.out.println(filePath);
		for(String t:resArray) {
			System.out.println(t);
		}
		System.out.println(new BigDecimal("0.99"));
	}
}