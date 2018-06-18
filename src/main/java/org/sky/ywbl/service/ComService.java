package org.sky.ywbl.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.client.TbStYwbhMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
import org.sky.ywbl.model.TbStYwbh;
import org.sky.ywbl.model.TbStYwbhExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName:  ComService   
 * @Description:TODO(通用Service)   
 * @author: weifx 
 * @date:   2018年4月12日 下午11:15:52   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class ComService {
	private final Logger logger=Logger.getLogger(ComService.class);
	@Autowired
	private TbStYwbhMapper ywbhMapper;
	@Autowired
	private TbStTxxxMapper txMapper;
	/**
	 * 获取业务编号
	 * @param szm
	 * @param jgdm
	 * @return
	 */
	public synchronized String getYwbh(String szm,String userCode,String jgdm) {
		int sxh=0;
		String ywbh="";
		String ny = CommonUtils.getCurrentDate("yyyyMM");
		TbStYwbhExample e = new TbStYwbhExample();
		e.createCriteria().andSzmEqualTo(szm).andJgdmEqualTo(jgdm).andNyEqualTo(ny);
		List<TbStYwbh> list = ywbhMapper.selectByExample(e);
		DecimalFormat df = new DecimalFormat("#0000");
		Date date = CommonUtils.getCurrentDbDate();
		if(list.isEmpty()) {
			sxh=1;
			TbStYwbh bh = new TbStYwbh();
			bh.setId(CommonUtils.getUUID(32));
			bh.setJgdm(jgdm);
			bh.setNy(ny);
			bh.setSxh(sxh);
			bh.setSzm(szm);
			bh.setCreater(userCode);
			bh.setCreateTime(date);
			bh.setUpdater(userCode);
			bh.setUpdateTime(date);
			ywbhMapper.insert(bh);
			ywbh=szm+jgdm+ny+df.format(sxh);
		}else {
			TbStYwbh bh = list.get(0);
			sxh=bh.getSxh()+1;
			bh.setSxh(sxh);
			bh.setUpdater(userCode);
			bh.setUpdateTime(date);
			ywbhMapper.updateByPrimaryKeySelective(bh);
			ywbh=szm+jgdm+ny+df.format(sxh);
		}
		return ywbh;
	}
	/**
	 * 根据业务类型，业务编号获取图像信息
	 * @param ywlx
	 * @param ywbh
	 * @return
	 */
	public List<TbStTxxx> selectTxxxByYW(String ywlx,String ywbh){
		TbStTxxxExample txe = new TbStTxxxExample();
		txe.createCriteria().andYwlxEqualTo(ywlx)
							.andYwbhEqualTo(ywbh);
		txe.setOrderByClause("create_time asc");
		return txMapper.selectByExampleWithBLOBs(txe);
	}
	/**
	 * 根据业务编号跟序号查询图像信息
	 * @param ywlx
	 * @param ywbh
	 * @return
	 */
	public TbStTxxx selectTxxxByYWXH(String ywlx,String ywbh,int xh){
		TbStTxxxExample txe = new TbStTxxxExample();
		txe.createCriteria().andYwlxEqualTo(ywlx)
							.andYwbhEqualTo(ywbh)
							.andSeqEqualTo(xh);
		List<TbStTxxx> list = txMapper.selectByExampleWithBLOBs(txe);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
}
