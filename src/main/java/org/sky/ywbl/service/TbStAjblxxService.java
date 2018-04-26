package org.sky.ywbl.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.ywbl.client.TbStAjblxxMapper;
import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.sky.ywbl.client.TbStAjlzxxMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjblxx;
import org.sky.ywbl.model.TbStAjblxxExample;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStAjlzxx;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStAjblxxService {
	private final Logger logger=Logger.getLogger(TbStAjblxxService.class);
	@Autowired
	private TbStAjblxxMapper tbstajblxxmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private TbStAjdjxxMapper djxxMapper;
	@Autowired
	private TbStAjlzxxMapper lzxxMapper;
	/**
	*分页查询
	**/
	public PageListData getTbStAjblxxByPage(TbStAjblxxExample ep){
		long totalCount = tbstajblxxmapper.countByExample(ep);
		List list = tbstajblxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStAjblxx(List<TbStAjblxx> addlist,
			List<TbStAjblxx> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStAjblxx add:addlist){
					tbstajblxxmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStAjblxx update:updatelist){
					tbstajblxxmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStAjblxx(TbStAjblxx add) throws ServiceException{
		try{
			tbstajblxxmapper.insertSelective(add);
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
	public void saveAddEditTbStAjblxx(TbStAjblxx edit,String flqx) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstajblxxmapper.insertSelective(edit);
				if(!StringUtils.isNull(flqx)) {
					//修改案件信息当前单位
					TbStAjdjxx aj = new TbStAjdjxx();
					aj.setDqdw(flqx);
					aj.setSjzt(edit.getBljg());
					TbStAjdjxxExample e = new TbStAjdjxxExample();
					e.createCriteria().andAjbhEqualTo(edit.getAjbh());
					djxxMapper.updateByExampleSelective(aj, e);
					//增加流转信息
					TbStAjlzxx lzxx = new TbStAjlzxx();
					lzxx.setId(CommonUtils.getUUID(32));
					lzxx.setAjbh(edit.getAjbh());
					lzxx.setDqdw(flqx);
					lzxx.setLzr(BspUtils.getLoginUser().getCode());
					lzxx.setLzdw(BspUtils.getLoginUser().getOrganCode());
					lzxx.setLzsj(ts);
					lzxx.setCreater(BspUtils.getLoginUser().getCode());
					lzxx.setCreateTime(ts);
					lzxxMapper.insert(lzxx);
				}
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstajblxxmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStAjblxxById(List<TbStAjblxx> delList){
		for(TbStAjblxx del:delList){
			tbstajblxxmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStAjblxx getTbStAjblxxById(String id){
		TbStAjblxx bean = tbstajblxxmapper.selectByPrimaryKey(id);
		return bean;
	}
}