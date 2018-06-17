package org.sky.sys.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysAreaMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysArea;
import org.sky.sys.model.SysAreaExample;
import org.sky.sys.model.SysOrgan;
import org.sky.sys.model.SysOrganExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.sys.utils.TreeStru;
@Service
public class SysAreaService {
	private final Logger logger=Logger.getLogger(SysAreaService.class);
	@Autowired
	private SysAreaMapper sysareamapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getSysAreaByPage(SysAreaExample ep){
		long totalCount = sysareamapper.countByExample(ep);
		List list = sysareamapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveSysArea(List<SysArea> addlist,
			List<SysArea> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(SysArea add:addlist){
					sysareamapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(SysArea update:updatelist){
					sysareamapper.updateByPrimaryKeySelective(update);
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
	public void saveAddSysArea(SysArea add) throws ServiceException{
		try{
			sysareamapper.insertSelective(add);
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
	public void saveAddEditSysArea(SysArea edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				sysareamapper.insertSelective(edit);
			}else{
				//修改
				sysareamapper.updateByPrimaryKeySelective(edit);
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
	public void delSysAreaById(List<SysArea> delList){
		for(SysArea del:delList){
			sysareamapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public SysArea getSysAreaById(String id){
		SysArea bean = sysareamapper.selectByPrimaryKey(id);
		return bean;
	}
	/**
	 * 查询组织机构树
	 * @param m
	 * @return
	 */
	public List<TreeStru> getSysOrganTree(Map m){
		List<TreeStru> list = new ArrayList();
		String code = (String)m.get("code");
		SysAreaExample sae = new SysAreaExample();
		sae.createCriteria().andParCodeEqualTo(code);
		List<SysArea> salist = sysareamapper.selectByExample(sae);
		for(SysArea sa:salist){
			TreeStru ts = new TreeStru();
			ts.setId(sa.getCode());
			ts.setText(sa.getName()+"["+sa.getCode()+"]");
			ts.setSeq(null==sa.getSeq()?0:sa.getSeq());
			ts.setIconCls("icon-map");
			if(sa.getChildCount()>0){
				ts.setState("closed");
			}else{
				ts.setState("open");
			}
			ts.setData(sa);
			list.add(ts);
		}
		return list;
	}
}