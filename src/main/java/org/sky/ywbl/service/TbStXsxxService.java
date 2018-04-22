package org.sky.ywbl.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.client.TbStXsxxMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
import org.sky.ywbl.model.TbStXsxx;
import org.sky.ywbl.model.TbStXsxxExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStXsxxService {
	private final Logger logger=Logger.getLogger(TbStXsxxService.class);
	@Autowired
	private TbStXsxxMapper tbstxsxxmapper;
	@Autowired
	private TbStTxxxMapper txxxmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStXsxxByPage(TbStXsxxExample ep){
		long totalCount = tbstxsxxmapper.countByExample(ep);
		List list = tbstxsxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStXsxx(List<TbStXsxx> addlist,
			List<TbStXsxx> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStXsxx add:addlist){
					tbstxsxxmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStXsxx update:updatelist){
					tbstxsxxmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStXsxx(TbStXsxx add) throws ServiceException{
		try{
			tbstxsxxmapper.insertSelective(add);
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
	public void saveAddEditTbStXsxx(TbStXsxx edit,List<TbStTxxx> txList) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			//先删除之前的图像信息 再插入新的图像信息
			TbStTxxxExample txe = new TbStTxxxExample();
			txe.createCriteria().andYwlxEqualTo("XSXX")
								.andYwbhEqualTo(edit.getXsbh());
			txxxmapper.deleteByExample(txe);
			for(TbStTxxx tx:txList) {
				tx.setId(CommonUtils.getUUID(32));
				tx.setCreater(BspUtils.getLoginUser().getCode());
				tx.setCreateTime(ts);
				tx.setYwbh(edit.getXsbh());
				tx.setYwlx("XSXX");
				txxxmapper.insert(tx);
			}
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstxsxxmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstxsxxmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStXsxxById(List<TbStXsxx> delList){
		for(TbStXsxx del:delList){
			tbstxsxxmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStXsxx getTbStXsxxById(String id){
		TbStXsxx bean = tbstxsxxmapper.selectByPrimaryKey(id);
		return bean;
	}
}