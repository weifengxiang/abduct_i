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
import org.sky.sys.model.SysUser;
import org.sky.sys.model.SysUserExample;
import org.sky.sys.utils.ApplicationCached;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	private Logger logger = Logger.getLogger(AppService.class);
	@Autowired
	private SysUserMapper sysuseMapper;
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
	
}
