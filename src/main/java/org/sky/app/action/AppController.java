package org.sky.app.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.app.service.AppService;
import org.sky.app.utils.AppConst;
import org.sky.app.utils.JwtUtil;
import org.sky.hdjl.model.TbStHdjlFs;
import org.sky.hdjl.model.TbStHdjlJs;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysFile;
import org.sky.sys.model.SysUser;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.MD5Utils;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.sky.utils.Base64Img;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStXsxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import net.sf.json.JSONObject;


/**
 * @ClassName: MiniAppController 
 * @Description: TODO(APP后台服务) 
 * @author AK
 * @date 2018-5-9 下午8:08:27 
 *
 */
@RestController
public class AppController extends BaseController{
	@Autowired
	private AppService appService;
	/**
	 * 注册接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/register",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody ResultData register(HttpServletRequest request, HttpServletResponse response){
		ResultData rd = new ResultData();
		String user = request.getParameter("user");
		SysUser su = JsonUtils.json2pojo(user, SysUser.class);
		
		try {
			appService.register(su);
			rd.setCode("1");
			rd.setName("注册成功,请等待审核");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rd.setCode("0");
			rd.setName("注册失败"+e.getMessage());
		}
		return rd;
	}
	/**
	 * 使用token登录
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/app/AppController/tokenLogin",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody ResultData tokenLogin(HttpServletRequest request, HttpServletResponse response){
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
	 * 登录接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody ResultData login(HttpServletRequest request, HttpServletResponse response){
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
	@RequestMapping(value="/app/AppController/selectDictItemByType",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List selectDictItemByType(HttpServletRequest request, HttpServletResponse response) {
		String dictCode = request.getParameter("dictCode");
		return appService.selectDictItemByType(dictCode);
	}
	/**
	 * 添加线索
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/app/AppController/AddXsxx", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody
	ResultData AddXsxx(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		ResultData rd = new ResultData();
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = (CommonsMultipartResolver)BspUtils.getBean("multipartResolver");
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)multipartResolver.resolveMultipart(request);
				List<SysFile> list = new ArrayList<SysFile>();
				//线索信息
				TbStXsxx xs = null;
				List<Field> idField = new ArrayList();
				idField=getAllField(idField, TbStXsxx.class);
				JSONObject js= new JSONObject();
				for (Field field : idField) {
					String name = field.getName();
					String str =  multiRequest.getParameter(name);
					if(str != null){
						js.put(name, str);
					}
				}
				xs = JsonUtils.json2pojo(js.toString(), TbStXsxx.class);
				List<String> tx = new ArrayList();
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile attachfile = multiRequest.getFile(iter.next());
					if (attachfile != null) {
						// 取得当前上传文件的文件名称
						String fileName = attachfile.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (fileName.trim() != "") {
							// 定义上传路径
							String path = ConfUtils.getValue("ATTACHMENT_DIR")
									+ "app" + File.separator
									+ "xsxx" + fileName;
							File localFile = new File(path);
							if (!localFile.getParentFile().exists()) {
								localFile.getParentFile().mkdirs();
							}
							attachfile.transferTo(localFile);
							String base64 =Base64Img.GetImageStr(localFile);
							tx.add(base64);
						}
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				}
				appService.AddXsxx(xs, tx, usercode);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("上传失败<br>" + e.getMessage());
			return rd;
		}
		rd.setCode(ResultData.code_success);
		rd.setName("上传成功");
		return rd;
	}
	@RequestMapping(value = "/app/AppController/AddAjxx", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody
	ResultData AddAjxx(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		ResultData rd = new ResultData();
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = (CommonsMultipartResolver)BspUtils.getBean("multipartResolver");
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)multipartResolver.resolveMultipart(request);
				List<SysFile> list = new ArrayList<SysFile>();
				//线索信息
				TbStAjdjxx aj = null;
				List<Field> idField = new ArrayList();
				idField=getAllField(idField, TbStAjdjxx.class);
				JSONObject js= new JSONObject();
				for (Field field : idField) {
					String name = field.getName();
					String str =  multiRequest.getParameter(name);
					if(str != null){
						js.put(name, str);
					}
				}
				aj = JsonUtils.json2pojo(js.toString(), TbStAjdjxx.class);
				List<String> tx = new ArrayList();
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile attachfile = multiRequest.getFile(iter.next());
					if (attachfile != null) {
						// 取得当前上传文件的文件名称
						String fileName = attachfile.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (fileName.trim() != "") {
							// 定义上传路径
							String path = ConfUtils.getValue("ATTACHMENT_DIR")
									+ "app" + File.separator
									+ "xsxx" + fileName;
							File localFile = new File(path);
							if (!localFile.getParentFile().exists()) {
								localFile.getParentFile().mkdirs();
							}
							attachfile.transferTo(localFile);
							String base64 =Base64Img.GetImageStr(localFile);
							tx.add(base64);
						}
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				}
				appService.AddAjxx(aj, tx, usercode);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("上传失败<br>" + e.getMessage());
			return rd;
		}
		rd.setCode(ResultData.code_success);
		rd.setName("上传成功");
		return rd;
	}
	/**
	 * 加载线索信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/loadXsxx",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List loadXsxx(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		return appService.loadXsxx(usercode);
	}
	/**
	 * 加载案件信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/loadAjxx",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List loadAjxx(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		return appService.loadAjxx(usercode);
	}
	/**
	 * 加载所有用户(联系人)信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/loadAllUsers",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List loadAllUsers(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		return appService.loadAllUsers();
	}
	/**
	 * 加载接收到的信息数量
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/loadReceiverMsgCount",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody Long loadReceiverMsgCount(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		return appService.loadReceiverMsgCount(usercode);
	}
	/**
	 * 查询接收到每个用户发送来的数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/loadReceiverMsgCountByUser",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List loadReceiverMsgCountByUser(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		return appService.loadReceiverMsgCountByUser(usercode);
	}
	/**
	 * 发送消息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/sendMsg",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody ResultData sendMsg(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		TbStHdjlFs fs = (TbStHdjlFs) this.getEntityBean(request, TbStHdjlFs.class);
		fs.setFsr(usercode);
		String jsr = request.getParameter("jsr");
		TbStHdjlJs js = new TbStHdjlJs();
		js.setJsr(jsr);
		List jslist = new ArrayList();
		jslist.add(js);
		appService.sendMsg(fs,jslist);
		ResultData rd = new ResultData();
		rd.setCode("1");
		rd.setName("发送成功");
		return rd;
	}
	/**
	 * 接收消息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/receiveMsg",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List<TbStHdjlFs> receiveMsg(HttpServletRequest request, HttpServletResponse response) {
		String usercode = (String) request.getAttribute(AppConst.REQUEST_LOGIN_MSG);
		String sender = request.getParameter("sender");
		return appService.receiveMsg(usercode,sender);
	}
	/**
	 * 查询所有组织机构
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/app/AppController/selectSysOrgan",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody List selectSysOrgan(HttpServletRequest request, HttpServletResponse response) {
		return appService.selectSysOrgan();
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
