package org.sky.sys.utils.schedule;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sjzq.client.TbStSjzqMapper;
import org.sky.sjzq.model.TbStSjzq;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.FTPUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
/**
 * @ClassName:  DataFtpUploadTxtJob   
 * @Description:TODO(数据抓取数据存放到ftp中)   
 * @author: weifx 
 * @date:   2019年7月10日 上午10:40:05   
 * @version V1.0    
 * @Copyright: 2019 XXX. All rights reserved.
 */
public class DataFtpUploadTxtJob implements Job {
	private final Logger logger=Logger.getLogger(DataFtpUploadTxtJob.class);
	//业务类型
	private final static String ywlx = "SJZQ";
	//临时文件
	private final static String tempDir = ConfUtils.getValue("temp_dir");
	//文件前缀
	private final static String filePrefix = "SGXT";
	//文件后缀
	private final static String fileSuffix = ".txt";
	//ftp配置
	private final static String ftpIp = "192.168.0.86";
	private final static int ftpPort = 21;
	private final static String ftpUserName = "ftpgnt";
	private final static String ftpPassword = "gntwifi@123";
	private final static String ftpPath = "input";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStSjzqMapper tbstsjzqmapper = BspUtils.getBean(TbStSjzqMapper.class);
		TbStTxxxMapper txMapper = BspUtils.getBean(TbStTxxxMapper.class);
		List<TbStSjzq> zqList = tbstsjzqmapper.selectByExample(null);
		TbStTxxxExample exam = new TbStTxxxExample();
		exam.createCriteria().andYwlxEqualTo(ywlx);
		List<TbStTxxx> txList = txMapper.selectByExampleWithBLOBs(exam);
		String tempFileName = tempDir+File.separator+filePrefix+CommonUtils.getCurrentDate("yyyy-MM-dd")+fileSuffix;
		File tempFile = new File(tempFileName);
		try {
			createFile(tempFile); 
			Map content = new HashMap();
			content.put("zqList", zqList);
			content.put("txList", txList);
			writeTxtFile(JsonUtils.obj2json(content),tempFile);
			ftpUpload(tempFile);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("生成txt上传ftp失败:"+e.getMessage());
		}
	}
	/**
	* 创建文件
	* @param fileName
	* @return
	*/
	public static boolean createFile(File fileName) throws Exception {
		boolean flag = false;
		try {
			if(!fileName.getParentFile().exists()) {
				fileName.getParentFile().mkdirs();
			}
			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean writeTxtFile(String content, File fileName) throws Exception {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("GBK"));
			o.close();
			// mm=new RandomAccessFile(fileName,"rw");
			// mm.writeBytes(content);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}
	/**
	 * 上传ftp
	 * @param file
	 */
	public static void ftpUpload(File file) {
		FTPUtils conf = new FTPUtils(ftpIp,ftpPort,ftpUserName,ftpPassword);
		conf.uploadFile(ftpPath, file, file.getName());
	}
}
