package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.log.SysControllerLog;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStAjjaxx;
import org.sky.ywbl.model.TbStAjjaxxExample;
import org.sky.ywbl.model.TbStAjjaxxExample.Criteria;
import org.sky.ywbl.service.TbStAjdjxxService;
import org.sky.ywbl.service.TbStAjjaxxService;
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
 * @ClassName:  TbStAjjaxxController   
 * @Description:TODO(案件结案信息)   
 * @author: weifx 
 * @date:   2018年4月19日 下午10:28:27   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TbStAjjaxxController extends BaseController{
	@Autowired
	private TbStAjjaxxService tbstajjaxxService;
	@Autowired
	private TbStAjdjxxService tbstajdjxxService;
	public TbStAjjaxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件结案信息列表页面
	**/
	@SysControllerLog(desc = "显示案件结案信息列表页面")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/initTbStAjjaxxListPage", method = { RequestMethod.GET })
	public String initTbStAjjaxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajja/listtbstajjaxx";
	}
	/**
	 * 案件结案信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@SysControllerLog(desc = "案件结案信息分页查询")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/getTbStAjjaxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjaxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjdjxxExample pote= new TbStAjdjxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstajdjxxService.getTbStAjdjxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示案件结案信息新增页面
	**/
	@SysControllerLog(desc = "显示案件结案信息新增页面")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/initAddTbStAjjaxxPage", method = { RequestMethod.GET })
	public String initAddTbStAjjaxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajja/edittbstajjaxx";
	}
	/**
	*显示案件结案信息修改页面
	**/
	@SysControllerLog(desc = "显示案件结案信息修改页面")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/initEditTbStAjjaxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjjaxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajja/edittbstajjaxx";
	}
	/**
	*显示案件结案信息详细页面
	**/
	@SysControllerLog(desc = "显示案件结案信息详细页面")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/initDetailTbStAjjaxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjjaxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajja/detailtbstajjaxx";
	}
	/**
	*保存新增/修改案件结案信息
	**/
	@SysControllerLog(desc = "保存新增/修改案件结案信息")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/saveAddEditTbStAjjaxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjjaxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStAjjaxx edit = (TbStAjjaxx) getEntityBean(request,TbStAjjaxx.class);
			tbstajjaxxService.saveAddEditTbStAjjaxx(edit);
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
	*删除案件结案信息
	**/
	@SysControllerLog(desc = "删除案件结案信息")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/delTbStAjjaxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjjaxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStAjjaxx.class);
			tbstajjaxxService.delTbStAjjaxxById(de);
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
	*根据主键查询案件结案信息
	**/
	@SysControllerLog(desc = "根据主键查询案件结案信息")
	@RequestMapping(value = "/ywbl/TbStAjjaxx/getTbStAjjaxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjaxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjjaxx bean = tbstajjaxxService.getTbStAjjaxxById(id);
		return JsonUtils.obj2json(bean);
	}
}