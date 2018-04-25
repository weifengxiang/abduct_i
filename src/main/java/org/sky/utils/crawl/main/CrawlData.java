package org.sky.utils.crawl.main;

import org.sky.sjzq.model.TbStSjzq;
/**
 * 
 * @ClassName:  CrawlData   
 * @Description:TODO(数据抓取数据结构)   
 * @author: weifx 
 * @date:   2018年4月24日 下午10:42:30   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class CrawlData {

	private TbStSjzq data;
	private String base64;
	public TbStSjzq getData() {
		return data;
	}
	public void setData(TbStSjzq data) {
		this.data = data;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
}
