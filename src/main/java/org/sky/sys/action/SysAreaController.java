package org.sky.sys.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.model.SysArea;
import org.sky.sys.model.SysAreaExample;
import org.sky.sys.model.SysAreaExample.Criteria;
import org.sky.sys.service.SysAreaService;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class SysAreaController extends BaseController{
	@Autowired
	private SysAreaService sysareaService;
	
	public SysAreaController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示省市区编码表列表页面
	**/
	@RequestMapping(value = "/bkcx/SysArea/initSysAreaListPage", method = { RequestMethod.GET })
	public String initSysAreaListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sys/area/listsysarea";
	}
	/**
	 * 省市区编码表分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bkcx/SysArea/getSysAreaByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getSysAreaByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		SysAreaExample pote= new SysAreaExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = sysareaService.getSysAreaByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示省市区编码表新增页面
	**/
	@RequestMapping(value = "/bkcx/SysArea/initAddSysAreaPage", method = { RequestMethod.GET })
	public String initAddSysAreaPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sys/area/editsysarea";
	}
	/**
	*显示省市区编码表修改页面
	**/
	@RequestMapping(value = "/bkcx/SysArea/initEditSysAreaPage", method = { RequestMethod.GET })
	public String initEditSysAreaPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sys/area/editsysarea";
	}
	/**
	*显示省市区编码表详细页面
	**/
	@RequestMapping(value = "/bkcx/SysArea/initDetailSysAreaPage", method = { RequestMethod.GET })
	public String initDetailSysAreaPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sys/area/detailsysarea";
	}
	/**
	*保存新增/修改省市区编码表
	**/
	@RequestMapping(value = "/bkcx/SysArea/saveAddEditSysArea", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditSysArea(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			SysArea edit = (SysArea) getEntityBean(request,SysArea.class);
			sysareaService.saveAddEditSysArea(edit);
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
	*删除省市区编码表
	**/
	@RequestMapping(value = "/bkcx/SysArea/delSysArea", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delSysArea(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, SysArea.class);
			sysareaService.delSysAreaById(de);
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
	*根据主键查询省市区编码表
	**/
	@RequestMapping(value = "/bkcx/SysArea/getSysAreaById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getSysAreaById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		SysArea bean = sysareaService.getSysAreaById(id);
		return JsonUtils.obj2json(bean);
	}
}