package org.sky.msg.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.msg.client.TbStMsgMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.msg.model.TbStMsg;
import org.sky.msg.model.TbStMsgExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStMsgService {
	private final Logger logger=Logger.getLogger(TbStMsgService.class);
	@Autowired
	private TbStMsgMapper tbstmsgmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStMsgByPage(TbStMsgExample ep){
		long totalCount = tbstmsgmapper.countByExample(ep);
		List list = tbstmsgmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStMsg(List<TbStMsg> addlist,
			List<TbStMsg> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStMsg add:addlist){
					tbstmsgmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStMsg update:updatelist){
					tbstmsgmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStMsg(TbStMsg add) throws ServiceException{
		try{
			tbstmsgmapper.insertSelective(add);
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
	public void saveAddEditTbStMsg(TbStMsg edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				//edit.setUpdater(BspUtils.getLoginUser().getCode());
				//edit.setUpdateTime(ts);
				tbstmsgmapper.insertSelective(edit);
			}else{
				//修改
				//edit.setUpdater(BspUtils.getLoginUser().getCode());
				//edit.setUpdateTime(ts);
				tbstmsgmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStMsgById(List<TbStMsg> delList){
		for(TbStMsg del:delList){
			tbstmsgmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStMsg getTbStMsgById(String id){
		TbStMsg bean = tbstmsgmapper.selectByPrimaryKey(id);
		return bean;
	}
}