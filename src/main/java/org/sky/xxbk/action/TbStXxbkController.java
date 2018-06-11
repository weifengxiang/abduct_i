package org.sky.xxbk.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.xxbk.model.TbStXxbk;
import org.sky.xxbk.model.TbStXxbkExample;
import org.sky.xxbk.model.TbStXxbkExample.Criteria;
import org.sky.xxbk.service.TbStXxbkService;
import org.sky.ywbl.service.ComService;
import org.sky.sys.utils.BspUtils;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class TbStXxbkController extends BaseController{
	@Autowired
	private TbStXxbkService tbstxxbkService;
	@Autowired
	private ComService comService;
	public TbStXxbkController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示信息布控列表页面
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/initTbStXxbkListPage", method = { RequestMethod.GET })
	public String initTbStXxbkListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bksz/listtbstxxbk";
	}
	/**
	 * 信息布控分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bksz/TbStXxbk/getTbStXxbkByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStXxbkByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStXxbkExample pote= new TbStXxbkExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstxxbkService.getTbStXxbkByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示信息布控新增页面
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/initAddTbStXxbkPage", method = { RequestMethod.GET })
	public ModelAndView initAddTbStXxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		String ywbh = comService.getYwbh("B", BspUtils.getLoginUser().getOrganCode());
		ModelAndView mv = new ModelAndView();
		mv.addObject("bh", ywbh);
		mv.setViewName("jsp/xxbk/bksz/edittbstxxbk");
		return mv;
	}
	/**
	*显示信息布控修改页面
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/initEditTbStXxbkPage", method = { RequestMethod.GET })
	public ModelAndView initEditTbStXxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/xxbk/bksz/edittbstxxbk");
		return mv;
	}
	/**
	*显示信息布控详细页面
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/initDetailTbStXxbkPage", method = { RequestMethod.GET })
	public String initDetailTbStXxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bksz/detailtbstxxbk";
	}
	/**
	*保存新增/修改信息布控
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/saveAddEditTbStXxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStXxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStXxbk edit = (TbStXxbk) getEntityBean(request,TbStXxbk.class);
			tbstxxbkService.saveAddEditTbStXxbk(edit);
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
	*删除信息布控
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/delTbStXxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStXxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStXxbk.class);
			tbstxxbkService.delTbStXxbkById(de);
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
	*根据主键查询信息布控
	**/
	@RequestMapping(value = "/bksz/TbStXxbk/getTbStXxbkById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStXxbkById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStXxbk bean = tbstxxbkService.getTbStXxbkById(id);
		return JsonUtils.obj2json(bean);
	}
}