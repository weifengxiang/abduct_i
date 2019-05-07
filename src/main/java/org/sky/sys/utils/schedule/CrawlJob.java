package org.sky.sys.utils.schedule;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.sjzq.service.TbStSjzqService;
import org.sky.sys.utils.BspUtils;

public class CrawlJob  implements Job {
	private final Logger logger=Logger.getLogger(CrawlJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStSjzqService sjzqService = BspUtils.getBean(TbStSjzqService.class);
		//String xqbhStr="319431";
		int xqbhBegin=319431;
		int xqbhEnd = 999999;
		for(int i=xqbhBegin;i<=xqbhEnd;i++) {
			System.out.println(i);
			String xqbhStr=i+"";
			if(sjzqService.countByXqbh(xqbhStr)==0) {
				logger.info("抓取"+xqbhStr+"... ...");
				try {
					sjzqService.crawlData(xqbhStr);
				}catch(Exception e) {
					e.printStackTrace();
					logger.error("抓取"+xqbhStr+"出错:"+e.getMessage());
				}
			}
		}
		
	}

}
