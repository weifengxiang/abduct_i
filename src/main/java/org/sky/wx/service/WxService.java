package org.sky.wx.service;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.utils.CommonUtils;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.client.TbStXsxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStXsxx;
import org.sky.ywbl.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @ClassName:  WxService   
 * @Description:TODO(微信服务)   
 * @author: weifx 
 * @date:   2018年10月11日 下午7:10:38   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class WxService {
	private Logger logger = Logger.getLogger(WxService.class);
	@Autowired
	private TbStXsxxMapper xsMapper;
	@Autowired
	private TbStTxxxMapper txMapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private ComService comService;
	public void addXsxx(TbStXsxx xs,String img) {
		String xsbh = comService.getYwbh("X","superadmin","370100000000");
		String id = CommonUtils.getUUID(32);
		Timestamp ts = syscommonmapper.queryTimestamp();
		xs.setId(id);
		xs.setXsbh(xsbh);
		xs.setCreater(xs.getJbr());
		xs.setCreateTime(ts);
		xs.setUpdater(xs.getJbr());
		xs.setUpdateTime(ts);
		xsMapper.insert(xs);
		TbStTxxx txbean = new TbStTxxx();
		txbean.setId(CommonUtils.getUUID(32));
		txbean.setYwbh(xsbh);
		txbean.setSeq(1);
		txbean.setYwlx("XSXX");
		txbean.setTxlx("jpg");
		txbean.setTxnr(img);
		txbean.setCreater(xs.getJbr());
		txbean.setCreateTime(ts);
		txMapper.insert(txbean);
	}
}
