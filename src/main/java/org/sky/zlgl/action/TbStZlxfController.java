package org.sky.zlgl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.zlgl.model.TbStZlfkExample;
import org.sky.zlgl.model.TbStZlxf;
import org.sky.zlgl.model.TbStZlxfExample;
import org.sky.zlgl.model.TbStZlxfExample.Criteria;
import org.sky.zlgl.service.TbStZlfkService;
import org.sky.zlgl.service.TbStZlxfService;
import org.sky.sys.utils.BspUtils;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class TbStZlxfController extends BaseController{
	@Autowired
	private TbStZlxfService tbstzlxfService;
	@Autowired
	private TbStZlfkService tbstzlfkService;
	@Autowired
	private ComService comService;
	public TbStZlxfController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示指令下发列表页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/initTbStZlxfListPage", method = { RequestMethod.GET })
	public String initTbStZlxfListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlxf/listtbstzlxf";
	}
	/**
	 * 指令下发分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zlgl/TbStZlxf/getTbStZlxfByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStZlxfByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStZlxfExample pote= new TbStZlxfExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstzlxfService.getTbStZlxfByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示指令下发新增页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/initAddTbStZlxfPage", method = { RequestMethod.GET })
	public ModelAndView initAddTbStZlxfPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView  mv = new ModelAndView();
		String zlbh = comService.getYwbh("Z", BspUtils.getLoginUser().getCode(),BspUtils.getLoginUser().getOrganCode());
		mv.addObject("zlbh", zlbh);
		mv.setViewName("jsp/zlgl/zlxf/edittbstzlxf");
		return mv;
	}
	/**
	*显示指令下发修改页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/initEditTbStZlxfPage", method = { RequestMethod.GET })
	public String initEditTbStZlxfPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlxf/edittbstzlxf";
	}
	/**
	*显示指令下发详细页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/initDetailTbStZlxfPage", method = { RequestMethod.GET })
	public String initDetailTbStZlxfPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlxf/detailtbstzlxf";
	}
	/**
	*保存新增/修改指令下发
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/saveAddEditTbStZlxf", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStZlxf(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStZlxf edit = (TbStZlxf) getEntityBean(request,TbStZlxf.class);
			tbstzlxfService.saveAddEditTbStZlxf(edit);
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
	*删除指令下发
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/delTbStZlxf", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStZlxf(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStZlxf.class);
			tbstzlxfService.delTbStZlxfById(de);
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
	*根据主键查询指令下发
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/getTbStZlxfById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStZlxfById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStZlxf bean = tbstzlxfService.getTbStZlxfById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	*根据主键查询指令下发
	**/
	@RequestMapping(value = "/zlgl/TbStZlxf/getTbStZlxfByZlbh", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStZlxfByZlbh(
			HttpServletRequest request, 
			HttpServletResponse response){
		String zlbh = request.getParameter("zlbh");
		TbStZlxf bean = tbstzlxfService.getTbStZlxfByZlbh(zlbh);
		return JsonUtils.obj2json(bean);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zlgl/TbStZlxf/initTbStZlFKPage", method = { RequestMethod.GET })
	public String initTbStZlFKPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlxf/listtbstzlfk";
	}
	@RequestMapping(value = "/zlgl/TbStZlxf/getTbStZlfkByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStZlfkByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStZlfkExample pote= new TbStZlfkExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstzlfkService.getTbStZlfkByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
}