package org.sky.txbk.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.txbk.client.TbStTxbkjgMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.txbk.model.TbStTxbkjg;
import org.sky.txbk.model.TbStTxbkjgExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStTxbkjgService {
	private final Logger logger=Logger.getLogger(TbStTxbkjgService.class);
	@Autowired
	private TbStTxbkjgMapper tbsttxbkjgmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStTxbkjgByPage(TbStTxbkjgExample ep){
		long totalCount = tbsttxbkjgmapper.countByExample(ep);
		List list = tbsttxbkjgmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStTxbkjg(List<TbStTxbkjg> addlist,
			List<TbStTxbkjg> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStTxbkjg add:addlist){
					tbsttxbkjgmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStTxbkjg update:updatelist){
					tbsttxbkjgmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStTxbkjg(TbStTxbkjg add) throws ServiceException{
		try{
			tbsttxbkjgmapper.insertSelective(add);
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
	public void saveAddEditTbStTxbkjg(TbStTxbkjg edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreateTime(ts);
				tbsttxbkjgmapper.insertSelective(edit);
			}else{
				//修改
				tbsttxbkjgmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStTxbkjgById(List<TbStTxbkjg> delList){
		for(TbStTxbkjg del:delList){
			tbsttxbkjgmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStTxbkjg getTbStTxbkjgById(String id){
		TbStTxbkjg bean = tbsttxbkjgmapper.selectByPrimaryKey(id);
		return bean;
	}
}