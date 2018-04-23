package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjshxx;
import org.sky.ywbl.model.TbStAjshxxExample;
import org.sky.ywbl.model.TbStAjshxxExample.Criteria;
import org.sky.ywbl.service.TbStAjshxxService;
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
/**
 * 
 * @ClassName:  TbStAjshxxController   
 * @Description:TODO(案件审核信息)   
 * @author: weifx 
 * @date:   2018年4月22日 下午11:22:37   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TbStAjshxxController extends BaseController{
	@Autowired
	private TbStAjshxxService tbstajshxxService;
	
	public TbStAjshxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件审核列表页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/initTbStAjshxxListPage", method = { RequestMethod.GET })
	public String initTbStAjshxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajsh/listtbstajshxx";
	}
	/**
	 * 案件审核分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ywbl/TbStAjshxx/getTbStAjshxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjshxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjshxxExample pote= new TbStAjshxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstajshxxService.getTbStAjshxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示案件审核新增页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/initAddTbStAjshxxPage", method = { RequestMethod.GET })
	public String initAddTbStAjshxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajsh/edittbstajshxx";
	}
	/**
	*显示案件审核修改页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/initEditTbStAjshxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjshxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajsh/edittbstajshxx";
	}
	/**
	*显示案件审核详细页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/initDetailTbStAjshxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjshxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajsh/detailtbstajshxx";
	}
	/**
	*保存新增/修改案件审核
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/saveAddEditTbStAjshxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjshxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStAjshxx edit = (TbStAjshxx) getEntityBean(request,TbStAjshxx.class);
			tbstajshxxService.saveAddEditTbStAjshxx(edit);
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
	*删除案件审核
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/delTbStAjshxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjshxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStAjshxx.class);
			tbstajshxxService.delTbStAjshxxById(de);
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
	*根据主键查询案件审核
	**/
	@RequestMapping(value = "/ywbl/TbStAjshxx/getTbStAjshxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjshxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjshxx bean = tbstajshxxService.getTbStAjshxxById(id);
		return JsonUtils.obj2json(bean);
	}
}