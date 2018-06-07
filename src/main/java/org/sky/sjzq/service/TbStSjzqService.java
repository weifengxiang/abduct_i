package org.sky.sjzq.service;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sky.sys.client.SysCommonMapper;
import org.sky.sjzq.client.TbStSjzqMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sjzq.model.TbStSjzq;
import org.sky.sjzq.model.TbStSjzqExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BigExcel;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.utils.crawl.main.CrawlData;
import org.sky.utils.crawl.main.MyCrawlerUtils;
import org.sky.utils.crawl.util.FileTool;
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
	 * 根据寻亲编号查询
	 * @param xqbh
	 * @return
	 */
	public TbStSjzq getTbStSjzqByXqbh(String xqbh){
		TbStSjzqExample e = new TbStSjzqExample();
		e.createCriteria().andXqbhEqualTo(xqbh);
		List<TbStSjzq> list = tbstsjzqmapper.selectByExample(e);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 保存爬取数据
	 * @param xqbh
	 */
	@Transactional
	public void crawlData(String xqbh) {
		try {
		CrawlData cd = MyCrawlerUtils.crawling(xqbh);
		TbStSjzq sj = cd.getData();
		String fileName = cd.getImgName();
		if(null!=sj) {
			Timestamp ts = syscommonmapper.queryTimestamp();
			sj.setId(CommonUtils.getUUID(32));
			sj.setCreateTime(ts);
			tbstsjzqmapper.insert(sj);
			if(!StringUtils.isNull(fileName)) {
				TbStTxxx tx = new TbStTxxx();
				tx.setId(CommonUtils.getUUID(32));
				tx.setYwbh(xqbh);
				tx.setYwlx("SJZQ");
				File f = new File(fileName);
				tx.setTxnr("data:image/jpeg;base64,"+FileTool.getImageStr(f));
				tx.setTxlx(fileName.split("\\.")[fileName.split("\\.").length-1]);
				tx.setSeq(1);
				txMapper.insert(tx);
			}
		}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	public int countByXqbh(String xqbh) {
		TbStSjzqExample e = new TbStSjzqExample();
		e.createCriteria().andXqbhEqualTo(xqbh);
		return tbstsjzqmapper.countByExample(e);
	}
	public String createSjzqExcel(Map filter) {
		String filepath=null;
		List<Map> res = new ArrayList();
		Map params = new HashMap();
		TbStSjzqExample e = new TbStSjzqExample();
		e.createCriteria();
		if(null!=filter) {
			e.integratedQuery(filter);
		}
		List<TbStSjzq> list = tbstsjzqmapper.selectByExample(e);
		for(TbStSjzq zq:list) {
			String temp = JsonUtils.obj2json(zq);
			res.add(JsonUtils.json2map(temp));
		}
		filepath = ConfUtils.getValue("temp_dir")+File.separator+"crawl"
				   +File.separator+BspUtils.getLoginUser().getCode()+".xls";
		String[] titles={"寻亲编号","寻亲类别","姓名","性别","出生日期","失踪时身高","失踪时间","失踪人所在地","失踪地点","寻亲者特征描述","其他资料"};
		String[] fields={"xqbh","xqlb","xm","xb","csrq","szssg","szsj","szrszd","szdd","xqztzms","qtzl"};
		BigExcel.createExcel(filepath,CommonUtils.getCurrentDate("yyyy-MM-dd")+"数据抓取", titles,fields,res);
		return filepath;
	}
}