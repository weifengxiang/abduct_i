package org.sky.sys.utils.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sjzq.service.TbStSjzqService;
import org.sky.sys.utils.BspUtils;

public class CrawlJob  implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStSjzqService sjzqService = BspUtils.getBean(TbStSjzqService.class);
		int xqbh=sjzqService.getMaxXqbh();
		String xqbhStr="319431";
		if(0!=xqbh) {
			xqbhStr=xqbh+1+"";
		}
		sjzqService.crawlData(xqbhStr);
	}

}
