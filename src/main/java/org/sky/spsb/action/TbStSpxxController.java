package org.sky.spsb.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysFile;
import org.sky.spsb.model.TbStSpxx;
import org.sky.spsb.model.TbStSpxxExample;
import org.sky.spsb.model.TbStSpxxExample.Criteria;
import org.sky.spsb.service.TbStSpxxService;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.sky.ywbl.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class TbStSpxxController extends BaseController{
	@Autowired
	private TbStSpxxService tbstspxxService;
	@Autowired
	private ComService comService;
	public TbStSpxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示视频信息列表页面
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/initTbStSpxxListPage", method = { RequestMethod.GET })
	public String initTbStSpxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/listtbstspxx";
	}
	/**
	 * 视频信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/spsb/TbStSpxx/getTbStSpxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSpxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStSpxxExample pote= new TbStSpxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstspxxService.getTbStSpxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示视频信息新增页面
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/initAddTbStSpxxPage", method = { RequestMethod.GET })
	public ModelAndView initAddTbStSpxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String spbh = comService.getYwbh("V",BspUtils.getLoginUser().getCode(), BspUtils.getLoginUser().getOrganCode());
		mv.addObject("spbh",spbh);
		mv.setViewName("jsp/spsb/edittbstspxx");
		return mv;
	}
	/**
	*显示视频信息修改页面
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/initEditTbStSpxxPage", method = { RequestMethod.GET })
	public String initEditTbStSpxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/edittbstspxx";
	}
	/**
	*显示视频信息详细页面
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/initDetailTbStSpxxPage", method = { RequestMethod.GET })
	public String initDetailTbStSpxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/detailtbstspxx";
	}
	/**
	*保存新增/修改视频信息
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/saveAddEditTbStSpxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStSpxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = (CommonsMultipartResolver)BspUtils.getBean("multipartResolver");
			// 判断 request 是否有文件上传,即多部分请求
			TbStSpxx edit = new TbStSpxx();
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)multipartResolver.resolveMultipart(request);
				Map<String, Object> paramMap = new HashMap();
				List<SysFile> list = new ArrayList<SysFile>();
				String spbh = multiRequest.getParameter("spbh");
				String spmc = multiRequest.getParameter("spmc");
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setSpbh(spbh);
				edit.setSpmc(spmc);
				edit.setCreateTime(CommonUtils.getCurrentDbDate());
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					List<MultipartFile> attachfiles = multiRequest.getFiles(iter.next());
					if (attachfiles != null) {
						// 定义上传路径
						String filepath = ConfUtils.getValue("SP_DIR")+"//"+spbh;
						File fileDir = new File(filepath);
						if(!fileDir.exists()) {
							fileDir.mkdirs();
						}
						for(MultipartFile attachfile:attachfiles) {
							// 取得当前上传文件的文件名称
							String fileName = attachfile.getOriginalFilename();
							// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
							if (fileName.trim() != "") {
								File localFile = new File(filepath+File.separator+fileName);
								attachfile.transferTo(localFile);
							}
						}
						edit.setSplj(filepath);
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				}
			}
			tbstspxxService.saveAddEditTbStSpxx(edit);
			rd.setCode(ResultData.code_success);
			rd.setName("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("保存失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*删除视频信息
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/delTbStSpxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStSpxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStSpxx.class);
			tbstspxxService.delTbStSpxxById(de);
			rd.setCode(ResultData.code_success);
			rd.setName("删除成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("删除失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*根据主键查询视频信息
	**/
	@RequestMapping(value = "/spsb/TbStSpxx/getTbStSpxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSpxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStSpxx bean = tbstspxxService.getTbStSpxxById(id);
		return JsonUtils.obj2json(bean);
	}
}