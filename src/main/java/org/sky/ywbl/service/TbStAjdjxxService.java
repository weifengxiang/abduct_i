package org.sky.ywbl.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.sky.ywbl.client.TbStAjlzxxMapper;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStAjlzxx;
import org.sky.ywbl.model.TbStAjlzxxExample;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStAjdjxxService {
	private final Logger logger=Logger.getLogger(TbStAjdjxxService.class);
	@Autowired
	private TbStAjdjxxMapper tbstajdjxxmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private TbStTxxxMapper txxxmapper;
	@Autowired
	private TbStAjlzxxMapper lzxxmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStAjdjxxByPage(TbStAjdjxxExample ep){
		long totalCount = tbstajdjxxmapper.countByExample(ep);
		List list = tbstajdjxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStAjdjxx(List<TbStAjdjxx> addlist,
			List<TbStAjdjxx> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStAjdjxx add:addlist){
					tbstajdjxxmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStAjdjxx update:updatelist){
					tbstajdjxxmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStAjdjxx(TbStAjdjxx add) throws ServiceException{
		try{
			tbstajdjxxmapper.insertSelective(add);
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
	public void saveAddEditTbStAjdjxx(TbStAjdjxx edit,List<TbStTxxx> txList) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			//先删除之前的图像信息 再插入新的图像信息
			TbStTxxxExample txe = new TbStTxxxExample();
			txe.createCriteria().andYwlxEqualTo("AJXX")
								.andYwbhEqualTo(edit.getAjbh());
			txxxmapper.deleteByExample(txe);
			for(TbStTxxx tx:txList) {
				tx.setId(CommonUtils.getUUID(32));
				tx.setCreater(BspUtils.getLoginUser().getCode());
				tx.setCreateTime(ts);
				tx.setYwbh(edit.getAjbh());
				tx.setYwlx("AJXX");
				String fileName= tx.getTxmc();
				tx.setTxlx(fileName.split("\\.")[fileName.split("\\.").length-1]);
				txxxmapper.insert(tx);
			}
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstajdjxxmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(BspUtils.getLoginUser().getCode());
				edit.setUpdateTime(ts);
				tbstajdjxxmapper.updateByPrimaryKeySelective(edit);
			}
			//记录流转记录表
			TbStAjlzxx lzxx = new TbStAjlzxx();
			lzxx.setId(CommonUtils.getUUID(32));
			lzxx.setAjbh(edit.getAjbh());
			lzxx.setDqdw(BspUtils.getLoginUser().getOrganCode());
			lzxx.setLzr(BspUtils.getLoginUser().getCode());
			lzxx.setLzdw(BspUtils.getLoginUser().getOrganCode());
			lzxx.setAjzt(edit.getSjzt());
			lzxx.setLzsj(ts);
			lzxx.setCreater(BspUtils.getLoginUser().getCode());
			lzxx.setCreateTime(ts);
			lzxx.setUpdater(BspUtils.getLoginUser().getCode());
			lzxx.setUpdateTime(ts);
			lzxxmapper.insert(lzxx);
		}catch(Exception e){
			logger.error("保存新增/编辑单个对象执行失败",e);
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*根据主键批量删除对象
	**/
	@Transactional
	public void delTbStAjdjxxById(List<TbStAjdjxx> delList){
		for(TbStAjdjxx del:delList){
			tbstajdjxxmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStAjdjxx getTbStAjdjxxById(String id){
		TbStAjdjxx bean = tbstajdjxxmapper.selectByPrimaryKey(id);
		return bean;
	}
	public TbStAjdjxx getTbStAjdjxxByAjbh(String ajbh){
		TbStAjdjxxExample e = new TbStAjdjxxExample();
		e.createCriteria().andAjbhEqualTo(ajbh);
		List<TbStAjdjxx> list = tbstajdjxxmapper.selectByExample(e);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 查询案件流转信息
	 * @param ep
	 * @return
	 */
	public PageListData getTbStAjlzxxByPage(TbStAjlzxxExample ep){
		long totalCount = lzxxmapper.countByExample(ep);
		List list = lzxxmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
}