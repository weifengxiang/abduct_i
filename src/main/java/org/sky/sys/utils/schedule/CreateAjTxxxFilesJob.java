package org.sky.sys.utils.schedule;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
/**
 * 
 * @ClassName:  CreateAjTxxxFiles   
 * @Description:TODO(创建案件失踪人口图像库)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:06:14   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class CreateAjTxxxFilesJob implements Job {
	private final Logger logger=Logger.getLogger(CreateAjTxxxFilesJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStTxxxMapper txxxMapper = BspUtils.getBean(TbStTxxxMapper.class);
		TbStTxxxExample txxxe = new TbStTxxxExample();
		txxxe.createCriteria().andYwlxEqualTo("AJXX");
		List<TbStTxxx> list = txxxMapper.selectByExampleWithBLOBs(txxxe);
		String dir = ConfUtils.getValue("AJXXTX_DIR");
		for(TbStTxxx tx:list) {
			String filepath = dir+tx.getYwbh()+"_"+tx.getSeq()+"."+tx.getTxlx();
			File f = new File(filepath);
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			try {
				Base64Img.GenerateImage(tx.getTxnr(), filepath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
