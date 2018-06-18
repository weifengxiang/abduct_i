package org.sky.app.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.service.AppService;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.JwtUtil;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysUser;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: MiniAppController 
 * @Description: TODO(APP后台服务) 
 * @author AK
 * @date 2018-5-9 下午8:08:27 
 *
 */
@RestController
public class AppController {
	@Autowired
	private AppService appService;
	
	/**
	 * 使用token登录
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/app/AppController/tokenLogin",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData tokenLogin(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		try {
			String token = request.getParameter("refreshToken");
			if(null==token||"".equals(token)){
				rd.setCode(AppConst.PARAMETER_NULL);
				rd.setName(AppConst.PARAMETER_NULL_DESCRIPTION);
				return rd;
			}
			//解析token值
			rd = JwtUtil.parseJWT(token, JwtUtil.TOKEN_TYPE_REFRESH);
			if(!AppConst.SUCCESS.equals(rd.getCode())){
				return rd;
			}
			String code = (String) rd.getData();
			//判断必要信息是否存在
			if(null==code||"".equals(code)){
				rd.setCode(AppConst.TOKEN_ERROR);
				rd.setName(AppConst.TOKEN_ERROR_DESCRIPTION);
				return rd;
			}
			//从数据库获取渠道用户信息
			SysUser su = appService.getSysUserByCode(code);
			loginSuccessResult(rd,su);
			return rd;
		} catch (Exception e) {
			rd.setCode("0");
			rd.setName("登录失败,请从新登录,"+e.getMessage());
			return rd;
		}
	}
	
	/**
	 * 渠道登录接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData login(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String usercode = request.getParameter("usercode");
		String password = request.getParameter("password");
		if(StringUtils.isNull(usercode)) {
			rd.setCode("0");
			rd.setName("登录失败,用户名不能为空");
			return rd;
		}else if(StringUtils.isNull(password)) {
			rd.setCode("0");
			rd.setName("登录失败,密码不能为空");
			return rd;
		}
		try {
			SysUser su = appService.login(usercode, password);
			loginSuccessResult(rd,su);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rd.setCode("0");
			rd.setName(e.getMessage());
		}
		return rd;
	}
	/**
	 * 忘记密码/修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/updatePassword",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResultData updatePassword(
			HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		//String channelCode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		String usercode = request.getParameter("usercode");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		try {
			appService.updatePassword(usercode,oldPassword,newPassword);
			rd.setCode("1");
			rd.setName("密码修改成功");
		}catch(Exception e) {
			rd.setCode("0");
			rd.setName("密码修改失败,"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 生成登录返回值
	 * @param rd
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private ResultData loginSuccessResult(ResultData rd,SysUser user) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("refreshToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_REFRESH,JwtUtil.JWT_REFRESH_EXP));
		resultMap.put("requestToken", JwtUtil.createJWT(user.getCode(),JwtUtil.TOKEN_TYPE_REQUEST,JwtUtil.JWT_REQUEST_EXP));
		resultMap.put("username", user.getName());
		resultMap.put("usercode", user.getCode());
		rd.setCode("1");
		rd.setName("登录成功");
		rd.setData(resultMap);
		return rd;
	}
}
