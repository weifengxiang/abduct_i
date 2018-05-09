package org.sky.sjzq.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.sjzq.model.TbStSjzq;
import org.sky.sjzq.model.TbStSjzqExample;
import org.sky.sjzq.model.TbStSjzqExample.Criteria;
import org.sky.sjzq.service.TbStSjzqService;
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
public class TbStSjzqController extends BaseController{
	@Autowired
	private TbStSjzqService tbstsjzqService;
	
	public TbStSjzqController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示数据抓取列表页面
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/initTbStSjzqListPage", method = { RequestMethod.GET })
	public String initTbStSjzqListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sjzq/sjzq/listtbstsjzq";
	}
	/**
	 * 数据抓取分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sjzq/TbStSjzq/getTbStSjzqByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSjzqByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStSjzqExample pote= new TbStSjzqExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstsjzqService.getTbStSjzqByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示数据抓取新增页面
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/initAddTbStSjzqPage", method = { RequestMethod.GET })
	public String initAddTbStSjzqPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sjzq/sjzq/edittbstsjzq";
	}
	/**
	*显示数据抓取修改页面
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/initEditTbStSjzqPage", method = { RequestMethod.GET })
	public String initEditTbStSjzqPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sjzq/sjzq/edittbstsjzq";
	}
	/**
	*显示数据抓取详细页面
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/initDetailTbStSjzqPage", method = { RequestMethod.GET })
	public String initDetailTbStSjzqPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/sjzq/sjzq/detailtbstsjzq";
	}
	/**
	*保存新增/修改数据抓取
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/saveAddEditTbStSjzq", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStSjzq(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStSjzq edit = (TbStSjzq) getEntityBean(request,TbStSjzq.class);
			tbstsjzqService.saveAddEditTbStSjzq(edit);
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
	*删除数据抓取
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/delTbStSjzq", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStSjzq(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStSjzq.class);
			tbstsjzqService.delTbStSjzqById(de);
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
	*根据主键查询数据抓取
	**/
	@RequestMapping(value = "/sjzq/TbStSjzq/getTbStSjzqById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSjzqById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStSjzq bean = tbstsjzqService.getTbStSjzqById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	 * 根据寻亲编号查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sjzq/TbStSjzq/getTbStSjzqByXqbh", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSjzqByXqbh(
			HttpServletRequest request, 
			HttpServletResponse response){
		String xqbh = request.getParameter("xqbh");
		TbStSjzq bean = tbstsjzqService.getTbStSjzqByXqbh(xqbh);
		return JsonUtils.obj2json(bean);
	}
}