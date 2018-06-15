package org.sky.zlgl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.zlgl.model.TbStZlfk;
import org.sky.zlgl.model.TbStZlfkExample;
import org.sky.zlgl.model.TbStZlfkExample.Criteria;
import org.sky.zlgl.service.TbStZlfkService;
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
public class TbStZlfkController extends BaseController{
	@Autowired
	private TbStZlfkService tbstzlfkService;
	
	public TbStZlfkController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示指令反馈列表页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/initTbStZlfkListPage", method = { RequestMethod.GET })
	public String initTbStZlfkListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlfk/listtbstzlfk";
	}
	/**
	 * 指令反馈分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zlgl/TbStZlfk/getTbStZlfkByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
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
	/**
	*显示指令反馈新增页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/initAddTbStZlfkPage", method = { RequestMethod.GET })
	public String initAddTbStZlfkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlfk/edittbstzlfk";
	}
	/**
	*显示指令反馈修改页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/initEditTbStZlfkPage", method = { RequestMethod.GET })
	public String initEditTbStZlfkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlfk/edittbstzlfk";
	}
	/**
	*显示指令反馈详细页面
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/initDetailTbStZlfkPage", method = { RequestMethod.GET })
	public String initDetailTbStZlfkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zlgl/zlfk/detailtbstzlfk";
	}
	/**
	*保存新增/修改指令反馈
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/saveAddEditTbStZlfk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStZlfk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStZlfk edit = (TbStZlfk) getEntityBean(request,TbStZlfk.class);
			tbstzlfkService.saveAddEditTbStZlfk(edit);
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
	*删除指令反馈
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/delTbStZlfk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStZlfk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStZlfk.class);
			tbstzlfkService.delTbStZlfkById(de);
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
	 * 接收指令
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zlgl/TbStZlfk/acceptTbStZlfk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String acceptTbStZlfk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String acceptRows=request.getParameter("acceptRows");
			List acc=JsonUtils.json2list(acceptRows, TbStZlfk.class);
			tbstzlfkService.acceptTbStZlfk(acc);
			rd.setCode(ResultData.code_success);
			rd.setName("接收成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("接收失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*根据主键查询指令反馈
	**/
	@RequestMapping(value = "/zlgl/TbStZlfk/getTbStZlfkById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStZlfkById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStZlfk bean = tbstzlfkService.getTbStZlfkById(id);
		return JsonUtils.obj2json(bean);
	}
}