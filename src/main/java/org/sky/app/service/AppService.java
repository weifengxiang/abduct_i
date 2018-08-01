package org.sky.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.sky.hdjl.client.TbStHdjlFsMapper;
import org.sky.hdjl.client.TbStHdjlJsMapper;
import org.sky.hdjl.model.TbStHdjlFs;
import org.sky.hdjl.model.TbStHdjlFsExample;
import org.sky.hdjl.model.TbStHdjlJs;
import org.sky.hdjl.model.TbStHdjlJsExample;
import org.sky.msg.client.TbStMsgMapper;
import org.sky.sys.client.SysCommonMapper;
import org.sky.sys.client.SysDictItemMapper;
import org.sky.sys.client.SysOrganMapper;
import org.sky.sys.client.SysUserMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysDictItemExample;
import org.sky.sys.model.SysOrgan;
import org.sky.sys.model.SysOrganExample;
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
import org.sky.zlgl.client.TbStZlfkMapper;
import org.sky.zlgl.client.TbStZlxfMapper;
import org.sky.zlgl.client.TbStZlxfTxrMapper;
import org.sky.zlgl.model.TbStZlfk;
import org.sky.zlgl.model.TbStZlxf;
import org.sky.zlgl.model.TbStZlxfTxr;
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
	private SysOrganMapper sysorganMapper;
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
	@Autowired
	private TbStHdjlFsMapper fsMapper;
	@Autowired
	private TbStHdjlJsMapper jsMapper;
	@Autowired
	private TbStZlxfMapper tbstzlxfmapper;
	@Autowired
	private TbStZlfkMapper tbstzlfkmapper;
	@Autowired
	private TbStZlxfTxrMapper txrMapper;
	@Autowired
	private TbStMsgMapper msgMapper;
	public void register(SysUser user) {
		Timestamp ts = syscommonmapper.queryTimestamp();
		user.setId(CommonUtils.getUUID(32));
		//user.setCreater(BspUtils.getLoginUser().getCode());
		user.setCreateTime(ts);
		//user.setUpdater(BspUtils.getLoginUser().getCode());
		user.setUpdateTime(ts);
		user.setStatus("R");
		sysuserMapper.insert(user);
	}
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
			if("R".equals(list.get(0).getStatus())) {
				new ServiceException("用户审核尚未通过，请等待");
			}
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
	/**
	 * 加载所有用户联系人信息
	 * @return
	 */
	public List loadAllUsers() {
		SysUserExample e = new SysUserExample();
		e.createCriteria().andCodeNotEqualTo("SUPERADMIN").andOrganCodeIsNotNull();
		List<SysUser> list = sysuserMapper.selectByExample(e);
		List<Contact> resList = new ArrayList();
		for(SysUser su:list) {
			String orgCode = su.getOrganCode();
			String orgName = su.getOrganName();
			boolean orgExist = false;
			for(Contact c:resList) {
				if(c.getOrganCode().equals(orgCode)) {
					orgExist=true;
					c.getUserList().add(su);
				}
			}
			if(!orgExist) {
				Contact c = new Contact();
				c.setOrganCode(orgCode);
				c.setOrganName(orgName);
				c.getUserList().add(su);
				resList.add(c);
			}
		}
		return resList;
	}
	/**
	 * 加载用户接受到的信息数量
	 * @param userCode
	 * @return
	 */
	public Long loadReceiverMsgCount(String userCode) {
		TbStHdjlJsExample e = new TbStHdjlJsExample();
		e.createCriteria().andJsrEqualTo(userCode).andZtEqualTo("0");
		return jsMapper.countByExample(e);
	}
	/**
	 * 接收消息按发送人分组
	 * @param userCode
	 * @return
	 */
	public List loadReceiverMsgCountByUser(String userCode) {
		return jsMapper.loadReceiverMsgCountByUser(userCode);
	}
	/**
	 * 消息发送
	 * @param fs
	 * @param js
	 */
	public void sendMsg(TbStHdjlFs fs,List<TbStHdjlJs> list) {
		Timestamp ts = syscommonmapper.queryTimestamp();
		fs.setId(CommonUtils.getUUID(32));
		fs.setFssj(ts);
		fsMapper.insert(fs);
		for(TbStHdjlJs js:list) {
			js.setId(CommonUtils.getUUID(32));
			js.setFsId(fs.getId());
			js.setZt("0");
			jsMapper.insert(js);
		}
	}
	/**
	 * 接收发送的消息
	 * @param userCode
	 * @return
	 */
	public List<TbStHdjlFs> receiveMsg(String userCode,String sender) {
		Timestamp ts = syscommonmapper.queryTimestamp();
		TbStHdjlFsExample fse = new TbStHdjlFsExample();
		fse.createCriteria();
		fse.setOrderByClause("fssj asc");
		Map filter = new HashMap();
		filter.put("exists(select 1 from tb_st_hdjl_js js where js.fs_id=tb_st_hdjl_fs.id and js.zt='0' and jsr='"+userCode+"') and 1@=", "1");
		filter.put("fsr@=", sender);
		fse.integratedQuery(filter);
		List list = fsMapper.selectByExample(fse);
		if(null!=list && !list.isEmpty()) {
			TbStHdjlJs js = new TbStHdjlJs();
			js.setZt("1");
			js.setJssj(ts);
			TbStHdjlJsExample e = new TbStHdjlJsExample();
			e.createCriteria();
			Map f = new HashMap();
			f.put("jsr@=", userCode);
			f.put("zt@=", "0");
			f.put("exists(select 1 from tb_st_hdjl_fs fs where fs.id=fs_id and fs.fsr='"+sender+"') and 1@=", "1");
			e.integratedQuery(f);
			jsMapper.updateByExampleSelective(js, e);
		}
		return list;
	}
	/**
	 * 查询所有组织机构
	 * @return
	 */
	public List<SysOrgan> selectSysOrgan(){
		SysOrganExample soe = new SysOrganExample();
		soe.setOrderByClause("code asc");
		return sysorganMapper.selectByExample(soe);
	}
	public void addzlxf(TbStZlxf edit,String usercode) {
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				edit.setCreater(usercode);
				edit.setCreateTime(ts);
				edit.setUpdater(usercode);
				edit.setUpdateTime(ts);
				edit.setXfsj(ts);
				String jsdw = edit.getJsdw();
				String txr = edit.getTxr();
				String[] jsdws = jsdw.split(",");
				String[] txrs = txr.split(",");
				for(String dwcode:jsdws) {
					TbStZlfk fk = new TbStZlfk();
					fk.setId(CommonUtils.getUUID(32));
					fk.setJsdw(dwcode);
					fk.setZlbh(edit.getZlbh());
					fk.setZt("0");
					fk.setCreater(usercode);
					fk.setCreateTime(ts);
					fk.setUpdater(usercode);
					fk.setUpdateTime(ts);
					tbstzlfkmapper.insert(fk);
					
				}
				for(String txrCode:txrs) {
					TbStZlxfTxr txrBean = new TbStZlxfTxr();
					txrBean.setId(CommonUtils.getUUID(32));
					txrBean.setTxr(txrCode);
					txrBean.setZlbh(edit.getZlbh());
					txrBean.setCreater(usercode);
					txrBean.setCreateTime(ts);
					txrBean.setUpdater(usercode);
					txrBean.setUpdateTime(ts);
					txrMapper.insert(txrBean);
					msgMapper.insertUserMsg(txrCode,"您有新的指令，请登录系统查看");
				}
				tbstzlxfmapper.insertSelective(edit);
			}else{
				//修改
				edit.setUpdater(usercode);
				edit.setUpdateTime(ts);
				tbstzlxfmapper.updateByPrimaryKeySelective(edit);
			}
		}catch(Exception e){
			logger.error("保存新增/编辑单个对象执行失败",e);
			throw new ServiceException(e.getMessage());
		}
	}
	class Contact{
		private String organCode;
		private String organName;
		private List<SysUser> userList=new ArrayList();
		public String getOrganCode() {
			return organCode;
		}
		public void setOrganCode(String organCode) {
			this.organCode = organCode;
		}
		public String getOrganName() {
			return organName;
		}
		public void setOrganName(String organName) {
			this.organName = organName;
		}
		public List<SysUser> getUserList() {
			return userList;
		}
		public void setUserList(List<SysUser> userList) {
			this.userList = userList;
		}
	}
}
