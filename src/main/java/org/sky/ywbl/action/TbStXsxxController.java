package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStXsxx;
import org.sky.ywbl.model.TbStXsxxExample;
import org.sky.ywbl.model.TbStXsxxExample.Criteria;
import org.sky.ywbl.service.TbStXsxxService;
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
public class TbStXsxxController extends BaseController{
	@Autowired
	private TbStXsxxService tbstxsxxService;
	
	public TbStXsxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示线索信息列表页面
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/initTbStXsxxListPage", method = { RequestMethod.GET })
	public String initTbStXsxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/xsgl/listtbstxsxx";
	}
	/**
	 * 线索信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ywbl/TbStXsxx/getTbStXsxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStXsxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStXsxxExample pote= new TbStXsxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstxsxxService.getTbStXsxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示线索信息新增页面
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/initAddTbStXsxxPage", method = { RequestMethod.GET })
	public String initAddTbStXsxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/xsgl/edittbstxsxx";
	}
	/**
	*显示线索信息修改页面
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/initEditTbStXsxxPage", method = { RequestMethod.GET })
	public String initEditTbStXsxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/xsgl/edittbstxsxx";
	}
	/**
	*显示线索信息详细页面
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/initDetailTbStXsxxPage", method = { RequestMethod.GET })
	public String initDetailTbStXsxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/xsgl/detailtbstxsxx";
	}
	/**
	*保存新增/修改线索信息
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/saveAddEditTbStXsxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStXsxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStXsxx edit = (TbStXsxx) getEntityBean(request,TbStXsxx.class);
			tbstxsxxService.saveAddEditTbStXsxx(edit);
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
	*删除线索信息
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/delTbStXsxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStXsxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStXsxx.class);
			tbstxsxxService.delTbStXsxxById(de);
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
	*根据主键查询线索信息
	**/
	@RequestMapping(value = "/ywbl/TbStXsxx/getTbStXsxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStXsxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStXsxx bean = tbstxsxxService.getTbStXsxxById(id);
		return JsonUtils.obj2json(bean);
	}
}