package org.sky.sjzq.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sjzq.client.TbStSjzqMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sjzq.model.TbStSjzq;
import org.sky.sjzq.model.TbStSjzqExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.utils.crawl.main.CrawlData;
import org.sky.utils.crawl.main.MyCrawlerUtils;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
@Service
public class TbStSjzqService {
	private final Logger logger=Logger.getLogger(TbStSjzqService.class);
	@Autowired
	private TbStSjzqMapper tbstsjzqmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private TbStTxxxMapper txMapper;
	/**
	*分页查询
	**/
	public PageListData getTbStSjzqByPage(TbStSjzqExample ep){
		long totalCount = tbstsjzqmapper.countByExample(ep);
		List list = tbstsjzqmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStSjzq(List<TbStSjzq> addlist,
			List<TbStSjzq> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStSjzq add:addlist){
					tbstsjzqmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStSjzq update:updatelist){
					tbstsjzqmapper.updateByPrimaryKeySelective(update);
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
	public void saveAddTbStSjzq(TbStSjzq add) throws ServiceException{
		try{
			tbstsjzqmapper.insertSelective(add);
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
	public void saveAddEditTbStSjzq(TbStSjzq edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreateTime(ts);
				tbstsjzqmapper.insertSelective(edit);
			}else{
				//修改
				tbstsjzqmapper.updateByPrimaryKeySelective(edit);
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
	public void delTbStSjzqById(List<TbStSjzq> delList){
		for(TbStSjzq del:delList){
			tbstsjzqmapper.deleteByPrimaryKey(del.getId());
		}
	}
	public int getMaxXqbh() {
		return tbstsjzqmapper.getMaxXQBH();
	}
	/**
	*根据主键查询对象
	**/
	public TbStSjzq getTbStSjzqById(String id){
		TbStSjzq bean = tbstsjzqmapper.selectByPrimaryKey(id);
		return bean;
	}
	/**
	 * 保存爬取数据
	 * @param xqbh
	 */
	@Transactional
	public void crawlData(String xqbh) {
		CrawlData cd = MyCrawlerUtils.crawling(xqbh);
		TbStSjzq sj = cd.getData();
		String base64 = cd.getBase64();
		if(null!=sj) {
			Timestamp ts = syscommonmapper.queryTimestamp();
			sj.setId(CommonUtils.getUUID(32));
			sj.setCreateTime(ts);
			tbstsjzqmapper.insert(sj);
			TbStTxxx tx = new TbStTxxx();
			tx.setId(CommonUtils.getUUID(32));
			tx.setYwbh(xqbh);
			tx.setYwlx("SJZQ");
			tx.setTxnr(base64);
			tx.setSeq(1);
			txMapper.insert(tx);
		}
	}
}