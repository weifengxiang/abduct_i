package org.sky.sys.utils.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
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

/**
 * 
 * @ClassName:  DataFtpDownloadTxtJob   
 * @Description:TODO(数据抓取下载到本地并保存数据库)   
 * @author: weifx 
 * @date:   2019年7月10日 下午12:14:10   
 * @version V1.0    
 * @Copyright: 2019 XXX. All rights reserved.
 */
public class DataFtpDownloadTxtJob implements Job {
	private final Logger logger=Logger.getLogger(DataFtpDownloadTxtJob.class);
	//业务类型
	private final static String ywlx = "SJZQ";
	//临时文件
	private final static String tempDir = ConfUtils.getValue("temp_dir");
	//文件前缀
	private final static String filePrefix = "SGXT";
	//文件后缀
	private final static String fileSuffix = ".txt";
	//ftp配置
	private final static String ftpIp = "56.23.0.221";
	private final static int ftpPort = 21;
	private final static String ftpUserName = "ftp";
	private final static String ftpPassword = "ysdss123";
	private final static String ftpPath = "input";
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		String tempFileName = tempDir+File.separator+filePrefix+CommonUtils.getCurrentDate("yyyy-MM-dd")+fileSuffix;
		File tempFile = new File(tempFileName);
		ftpDownload(tempFile);
		String text = readText(tempFile);
		Map map = JsonUtils.json2map(text);
		List<LinkedHashMap> zqList = (List<LinkedHashMap>)map.get("zqList");
		List<LinkedHashMap> txList = (List<LinkedHashMap>)map.get("txList");
		TbStSjzqMapper tbstsjzqmapper = BspUtils.getBean(TbStSjzqMapper.class);
		TbStTxxxMapper txMapper = BspUtils.getBean(TbStTxxxMapper.class);
		List<TbStSjzq> dbQqList = tbstsjzqmapper.selectByExample(null);
		for(LinkedHashMap lmp:zqList) {
			TbStSjzq zq = JsonUtils.map2pojo(lmp, TbStSjzq.class);
			//是否存在
			String xqbh = zq.getXqbh();
			boolean exists = false;
			for(TbStSjzq dbzq:dbQqList) {
				if(xqbh.equals(dbzq.getXqbh())) {
					exists=true;
				}
			}
			if(exists) {
				logger.info(xqbh+"已经存在不需要保存");
			}else {
				tbstsjzqmapper.insert(zq);
				for(LinkedHashMap txLmp:txList) {
					TbStTxxx tx = JsonUtils.map2pojo(txLmp,TbStTxxx.class);
					if(ywlx.equals(tx.getYwlx())&&
							xqbh.equals(tx.getYwbh())) {
						txMapper.insert(tx);
					}
				}
				logger.info(xqbh+"同步成功");
			}
		}
	}
	//下载文件
	public static void ftpDownload(File file) {
		FTPUtils conf = new FTPUtils(ftpIp,ftpPort,ftpUserName,ftpPassword);
		conf.downloadFileq(ftpPath, file.getName(), file);
	}
	 /**
     * 读入TXT文件
     */
	public static String readText(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
