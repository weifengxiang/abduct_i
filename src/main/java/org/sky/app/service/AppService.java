package org.sky.app.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysDictItemMapper;
import org.sky.sys.client.SysUserMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysDictItemExample;
import org.sky.sys.model.SysUser;
import org.sky.sys.model.SysUserExample;
import org.sky.sys.utils.ApplicationCached;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.StringUtils;
import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.client.TbStXsxxMapper;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStXsxx;
import org.sky.ywbl.model.TbStXsxxExample;
import org.sky.ywbl.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	private Logger logger = Logger.getLogger(AppService.class);
	@Autowired
	private SysUserMapper sysuseMapper;
	@Autowired
	private SysDictItemMapper sysdictitemMapper;
	@Autowired
	private SysUserMapper sysuserMapper;
	@Autowired
	private ComService comService;
	@Autowired
	private SysCommonMapper syscommonmapper;
	@Autowired
	private TbStXsxxMapper xsMapper;
	@Autowired
	private TbStTxxxMapper txMapper;
	@Autowired
	private TbStAjdjxxMapper ajMapper;
	/**
	 * 登录
	 * @param username
	 * @param password
	 */
	public SysUser login(String usercode,String password) throws ServiceException{
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(usercode).andPasswordEqualTo(password);
		List<SysUser> list = sysuseMapper.selectByExample(sue);
		if(null!=list && !list.isEmpty()) {
			return list.get(0);
		}
		throw new ServiceException("用户名或密码不正确");
	}
	/**
	 * 根据用户编号获取用户信息
	 * @param usercode
	 * @return
	 */
	public SysUser getSysUserByCode(String usercode) {
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(usercode);
		List<SysUser> list = sysuseMapper.selectByExample(sue);
		if(null!=list && !list.isEmpty()) {
			return list.get(0);
		}
		throw new ServiceException("用户登录名不正确");
	}
	/**
	 * 修改密码
	 * @param usercode
	 * @param oldPwd
	 * @param newPwd
	 */
	public void updatePassword(String usercode,String oldPwd,String newPwd) {
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(usercode).andPasswordEqualTo(MD5Utils.MD5LOWER(oldPwd));
		List<SysUser> list = sysuseMapper.selectByExample(sue);
		if(null!=list && !list.isEmpty()) {
			SysUser su = new SysUser();
			su.setId(list.get(0).getId());
			su.setPassword(MD5Utils.MD5LOWER(newPwd));
		}else {
			throw new ServiceException("用户名或密码不正确");
		}
	}
	/**
	 * 获取字典信息
	 * @param dictCode
	 * @return
	 */
	public List selectDictItemByType(String dictCode) {
		SysDictItemExample sde = new SysDictItemExample();
		sde.createCriteria().andDictCodeEqualTo(dictCode);
		return sysdictitemMapper.selectByExample(sde);
	}
	/**
	 * 添加线索信息
	 * @param xs
	 * @param tx
	 * @param userCode
	 */
	public void AddXsxx(TbStXsxx xs,List<String> tx,String userCode) {
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(userCode);
		List<SysUser> list = sysuserMapper.selectByExample(sue);
		String xsbh = comService.getYwbh("X",userCode,list.get(0).getOrganCode());
		Timestamp ts = syscommonmapper.queryTimestamp();
		xs.setId(CommonUtils.getUUID(32));
		xs.setXsbh(xsbh);
		xs.setCreater(userCode);
		xs.setCreateTime(ts);
		xs.setUpdater(userCode);
		xs.setUpdateTime(ts);
		xsMapper.insert(xs);
		for(int i=0;i<tx.size();i++) {
			TbStTxxx txbean = new TbStTxxx();
			txbean.setId(CommonUtils.getUUID(32));
			txbean.setYwbh(xsbh);
			txbean.setSeq(i+1);
			txbean.setYwlx("XSXX");
			txbean.setTxlx("jpg");
			txbean.setTxnr("data:image/jpeg;base64,"+tx.get(i));
			txbean.setCreater(userCode);
			txbean.setCreateTime(ts);
			txMapper.insert(txbean);
		}
	}
	/**
	 * 案件信息保存
	 * @param aj
	 * @param tx
	 * @param userCode
	 */
	public void AddAjxx(TbStAjdjxx aj,List<String> tx,String userCode) {
		SysUserExample sue = new SysUserExample();
		sue.createCriteria().andCodeEqualTo(userCode);
		List<SysUser> list = sysuserMapper.selectByExample(sue);
		String ajbh = comService.getYwbh("A",userCode,list.get(0).getOrganCode());
		Timestamp ts = syscommonmapper.queryTimestamp();
		aj.setId(CommonUtils.getUUID(32));
		aj.setAjbh(ajbh);
		aj.setSjzt("D1");
		aj.setDqdw(list.get(0).getOrganCode());
		aj.setCreater(userCode);
		aj.setCreateTime(ts);
		aj.setUpdater(userCode);
		aj.setUpdateTime(ts);
		ajMapper.insert(aj);
		for(int i=0;i<tx.size();i++) {
			TbStTxxx txbean = new TbStTxxx();
			txbean.setId(CommonUtils.getUUID(32));
			txbean.setYwbh(ajbh);
			txbean.setSeq(i+1);
			txbean.setYwlx("AJXX");
			txbean.setTxlx("jpg");
			txbean.setTxnr("data:image/jpeg;base64,"+tx.get(i));
			txbean.setCreater(userCode);
			txbean.setCreateTime(ts);
			txMapper.insert(txbean);
		}
	}
	/**
	 * 加载线索信息
	 * @param usercode
	 * @return
	 */
	public List loadXsxx(String usercode) {
		TbStXsxxExample sxe = new TbStXsxxExample();
		sxe.createCriteria().andCreaterEqualTo(usercode);
		sxe.setOrderByClause("create_time desc");
		return xsMapper.selectByExample(sxe);
	}
	/**
	 * 加载案件信息
	 * @param usercode
	 * @return
	 */
	public List loadAjxx(String usercode) {
		TbStAjdjxxExample sae = new TbStAjdjxxExample();
		sae.createCriteria().andCreaterEqualTo(usercode);
		sae.setOrderByClause("create_time desc");
		return ajMapper.selectByExample(sae);
	}
}
