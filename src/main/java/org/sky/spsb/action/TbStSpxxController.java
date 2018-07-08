package org.sky.spsb.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.spsb.model.TbStSpxx;
import org.sky.spsb.model.TbStSpxxExample;
import org.sky.spsb.model.TbStSpxxExample.Criteria;
import org.sky.spsb.service.TbStSpxxService;
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
public class TbStSpxxController extends BaseController{
	@Autowired
	private TbStSpxxService tbstspxxService;
	
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
	public String initAddTbStSpxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/edittbstspxx";
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
			TbStSpxx edit = (TbStSpxx) getEntityBean(request,TbStSpxx.class);
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