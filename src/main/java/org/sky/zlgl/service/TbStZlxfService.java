package org.sky.zlgl.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;

import org.sky.msg.client.TbStMsgMapper;
import org.sky.sys.client.SysCommonMapper;
import org.sky.zlgl.client.TbStZlfkMapper;
import org.sky.zlgl.client.TbStZlxfMapper;
import org.sky.zlgl.client.TbStZlxfTxrMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.zlgl.model.TbStZlfk;
import org.sky.zlgl.model.TbStZlxf;
import org.sky.zlgl.model.TbStZlxfExample;
import org.sky.zlgl.model.TbStZlxfTxr;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStZlxfService {
	private final Logger logger=Logger.getLogger(TbStZlxfService.class);
	@Autowired
	private TbStZlxfMapper tbstzlxfmapper;
	@Autowired
	private TbStZlfkMapper tbstzlfkmapper;
	@Autowired
	private TbStZlxfTxrMapper txrMapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private TbStMsgMapper msgMapper;
	/**
	*分页查询
	**/
	public PageListData getTbStZlxfByPage(TbStZlxfExample ep){
		long totalCount = tbstzlxfmapper.countByExample(ep);
		List list = tbstzlxfmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStZlxf(List<TbStZlxf> addlist,
			List<TbStZlxf> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStZlxf add:addlist){
					tbstzlxfmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStZlxf update:updatelist){
					tbstzlxfmapper.updateByPrimaryKeySelective(update);
				}
			}
		}catch(Exception e){
			logger.error("保存列表新增及修改执行失败",e);
			if(e.getMessage().contains("的值太大")){
				throw new ServiceException("输入的字段值过长！");
			}
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*保存添加单个对象
	**/
	@Transactional
	public void saveAddTbStZlxf(TbStZlxf add) throws ServiceException{
		try{
			tbstzlxfmapper.insertSelective(add);
		}catch(Exception e){
			logger.error("保存添加单个对象执行失败",e);
			if(e.getMessage().contains("违反唯一约束条件")){
				throw new ServiceException("违反唯一约束条件");
			}else{
				throw new ServiceException(e.getMessage());
			}
		}
	}
	/**
	*保存新增/编辑单个对象
	**/
	@Transactional
	public void saveAddEditTbStZlxf(TbStZlxf edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				String jsdw = edit.getJsdw();
				String txr = edit.getTxr();
				String[] jsdws = jsdw.split(",");
				String[] txrs = txr.split(",");
				for(String dwcode:jsdws) {
					TbStZlfk fk = new TbStZlfk();
					fk.setId(CommonUtils.getUUID(32));
					fk.setJsdw(dwcode);
					fk.setZlbh(edit.getZlbh());
					fk.setZt("0");
					fk.setCreater(BspUtils.getLoginUser().getCode());
					fk.setCreateTime(ts);
					fk.setUpdater(BspUtils.getLoginUser().getCode());
					fk.setUpdateTime(ts);
					tbstzlfkmapper.insert(fk);
					
				}
				for(String txrCode:txrs) {
					TbStZlxfTxr txrBean = new TbStZlxfTxr();
					txrBean.setId(CommonUtils.getUUID(32));
					txrBean.setTxr(txrCode);
					txrBean.setZlbh(edit.getZlbh());
					txrBean.setCreater(BspUtils.getLoginUser().getCode());
					txrBean.setCreateTime(ts);
					txrBean.setUpdater(BspUtils.getLoginUser().getCode());
					txrBean.setUpdateTime(ts);
					txrMapper.insert(txrBean);
					msgMapper.insertUserMsg(txrCode,"您有新的指令，请登录系统查看");
				}
				tbstzlxfmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstzlxfmapper.updateByPrimaryKeySelective(edit);
			}
		}catch(Exception e){
			logger.error("保存新增/编辑单个对象执行失败",e);
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*根据主键批量删除对象
	**/
	@Transactional
	public void delTbStZlxfById(List<TbStZlxf> delList){
		for(TbStZlxf del:delList){
			tbstzlxfmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStZlxf getTbStZlxfById(String id){
		TbStZlxf bean = tbstzlxfmapper.selectByPrimaryKey(id);
		return bean;
	}
	public TbStZlxf getTbStZlxfByZlbh(String zlbh){
		TbStZlxfExample e = new TbStZlxfExample();
		e.createCriteria().andZlbhEqualTo(zlbh);
		List<TbStZlxf> list = tbstzlxfmapper.selectByExample(e);
		if(null!=list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}