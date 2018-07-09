package org.sky.spsb.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.spsb.client.TbStSpxxMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.spsb.model.TbStSpxx;
import org.sky.spsb.model.TbStSpxxExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStSpxxService {
	private final Logger logger=Logger.getLogger(TbStSpxxService.class);
	@Autowired
	private TbStSpxxMapper tbstspxxmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStSpxxByPage(TbStSpxxExample ep){
		long totalCount = tbstspxxmapper.countByExample(ep);
		List list = tbstspxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStSpxx(List<TbStSpxx> addlist,
			List<TbStSpxx> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStSpxx add:addlist){
					tbstspxxmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStSpxx update:updatelist){
					tbstspxxmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStSpxx(TbStSpxx add) throws ServiceException{
		try{
			tbstspxxmapper.insertSelective(add);
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
	public void saveAddEditTbStSpxx(TbStSpxx edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				tbstspxxmapper.insertSelective(edit);
			}else{
				//修改
				tbstspxxmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStSpxxById(List<TbStSpxx> delList){
		for(TbStSpxx del:delList){
			tbstspxxmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStSpxx getTbStSpxxById(String id){
		TbStSpxx bean = tbstspxxmapper.selectByPrimaryKey(id);
		return bean;
	}
}