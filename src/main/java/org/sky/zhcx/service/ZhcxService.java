package org.sky.zhcx.service;

import java.util.List;

import org.sky.sys.utils.PageListData;
import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName:  ZhcxService   
 * @Description:TODO(综合查询)   
 * @author: weifx 
 * @date:   2018年6月16日 下午10:13:19   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class ZhcxService {
	@Autowired
	private TbStAjdjxxMapper tbstajdjxxmapper;
	/**
	 * 登记信息查询
	 * @param ep
	 * @return
	 */
	public PageListData getTbStAjdjxxByPage(TbStAjdjxxExample ep){
		long totalCount = tbstajdjxxmapper.countByExample(ep);
		List list = tbstajdjxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
}
