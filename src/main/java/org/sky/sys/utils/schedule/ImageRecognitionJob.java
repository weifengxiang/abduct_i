package org.sky.sys.utils.schedule;

import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sys.utils.BspUtils;
import org.sky.ywbl.client.TbStTxxxMapper;
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

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStTxxxMapper txxxMapper = BspUtils.getBean(TbStTxxxMapper.class);
		TbStTxxxExample txxxe = new TbStTxxxExample();
		txxxe.createCriteria().andYwlxEqualTo("AJXX");
		Map filter  = new HashMap();
		filter.put("ywlx@in","('SJZQ','XSXX')");
		filter.put("not exists(select 1 from tb_st_txsb tx where tx.) and 1@=",1);
	}

}
