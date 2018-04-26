package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.log.SysControllerLog;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjblxx;
import org.sky.ywbl.model.TbStAjblxxExample;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStAjblxxExample.Criteria;
import org.sky.ywbl.service.TbStAjblxxService;
import org.sky.ywbl.service.TbStAjdjxxService;
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
 * @ClassName:  TbStAjblxxController   
 * @Description:TODO(案件办理信息)   
 * @author: weifx 
 * @date:   2018年4月19日 下午9:48:44   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TbStAjblxxController extends BaseController{
	@Autowired
	private TbStAjblxxService tbstajblxxService;
	@Autowired
	private TbStAjdjxxService tbstajdjxxService;
	public TbStAjblxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件办理信息列表页面
	**/
	@SysControllerLog(desc = "显示案件办理信息列表页面")
	@RequestMapping(value = "/ywbl/TbStAjblxx/initTbStAjblxxListPage", method = { RequestMethod.GET })
	public String initTbStAjblxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajbl/listtbstajblxx";
	}
	/**
	 * 案件办理信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@SysControllerLog(desc = "案件办理信息分页查询")
	@RequestMapping(value = "/ywbl/TbStAjblxx/getTbStAjblxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjblxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjblxxExample pote= new TbStAjblxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstajblxxService.getTbStAjblxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示案件办理信息新增页面
	**/
	@SysControllerLog(desc = "显示案件办理信息新增页面")
	@RequestMapping(value = "/ywbl/TbStAjblxx/initAddTbStAjblxxPage", method = { RequestMethod.GET })
	public String initAddTbStAjblxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajbl/edittbstajblxx";
	}
	/**
	*显示案件办理信息修改页面
	**/
	@SysControllerLog(desc = "显示案件办理信息修改页面")
	@RequestMapping(value = "/ywbl/TbStAjblxx/initEditTbStAjblxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjblxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajbl/edittbstajblxx";
	}
	/**
	*显示案件办理信息详细页面
	**/
	@SysControllerLog(desc = "显示案件办理信息详细页面")
	@RequestMapping(value = "/ywbl/TbStAjblxx/initDetailTbStAjblxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjblxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajbl/detailtbstajblxx";
	}
	/**
	*保存新增/修改案件办理信息
	**/
	@SysControllerLog(desc = "保存新增/修改案件办理信息")
	@RequestMapping(value = "/ywbl/TbStAjblxx/saveAddEditTbStAjblxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjblxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String flqx = request.getParameter("flqx");
			TbStAjblxx edit = (TbStAjblxx) getEntityBean(request,TbStAjblxx.class);
			tbstajblxxService.saveAddEditTbStAjblxx(edit,flqx);
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
	*删除案件办理信息
	**/
	@SysControllerLog(desc = "删除案件办理信息")
	@RequestMapping(value = "/ywbl/TbStAjblxx/delTbStAjblxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjblxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStAjblxx.class);
			tbstajblxxService.delTbStAjblxxById(de);
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
	*根据主键查询案件办理信息
	**/
	@SysControllerLog(desc = "根据主键查询案件办理信息")
	@RequestMapping(value = "/ywbl/TbStAjblxx/getTbStAjblxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjblxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjblxx bean = tbstajblxxService.getTbStAjblxxById(id);
		return JsonUtils.obj2json(bean);
	}
}