package org.sky.xxbk.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.xxbk.model.TbStBkcx;
import org.sky.xxbk.model.TbStBkcxExample;
import org.sky.xxbk.model.TbStBkcxExample.Criteria;
import org.sky.xxbk.service.TbStBkcxService;
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
public class TbStBkcxController extends BaseController{
	@Autowired
	private TbStBkcxService tbstbkcxService;
	
	public TbStBkcxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示布控查询列表页面
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/initTbStBkcxListPage", method = { RequestMethod.GET })
	public String initTbStBkcxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bkcx/listtbstbkcx";
	}
	/**
	 * 布控查询分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bkcx/TbStBkcx/getTbStBkcxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStBkcxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStBkcxExample pote= new TbStBkcxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstbkcxService.getTbStBkcxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示布控查询新增页面
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/initAddTbStBkcxPage", method = { RequestMethod.GET })
	public String initAddTbStBkcxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bkcx/edittbstbkcx";
	}
	/**
	*显示布控查询修改页面
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/initEditTbStBkcxPage", method = { RequestMethod.GET })
	public String initEditTbStBkcxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bkcx/edittbstbkcx";
	}
	/**
	*显示布控查询详细页面
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/initDetailTbStBkcxPage", method = { RequestMethod.GET })
	public String initDetailTbStBkcxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bkcx/detailtbstbkcx";
	}
	/**
	*保存新增/修改布控查询
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/saveAddEditTbStBkcx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStBkcx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStBkcx edit = (TbStBkcx) getEntityBean(request,TbStBkcx.class);
			tbstbkcxService.saveAddEditTbStBkcx(edit);
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
	*删除布控查询
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/delTbStBkcx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStBkcx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStBkcx.class);
			tbstbkcxService.delTbStBkcxById(de);
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
	*根据主键查询布控查询
	**/
	@RequestMapping(value = "/bkcx/TbStBkcx/getTbStBkcxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStBkcxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStBkcx bean = tbstbkcxService.getTbStBkcxById(id);
		return JsonUtils.obj2json(bean);
	}
}