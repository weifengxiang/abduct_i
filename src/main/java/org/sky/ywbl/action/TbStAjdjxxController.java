package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.log.SysControllerLog;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.ywbl.model.TbStAjdjxxExample.Criteria;
import org.sky.ywbl.service.ComService;
import org.sky.ywbl.service.TbStAjdjxxService;
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
/**
 * 
 * @ClassName:  TbStAjdjxxController   
 * @Description:TODO(案件登记信息)   
 * @author: weifx 
 * @date:   2018年4月19日 下午9:49:01   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TbStAjdjxxController extends BaseController{
	@Autowired
	private TbStAjdjxxService tbstajdjxxService;
	@Autowired
	private ComService comService;
	public TbStAjdjxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件登记信息列表页面
	**/
	@SysControllerLog(desc = "显示案件登记信息列表页面")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/initTbStAjdjxxListPage", method = { RequestMethod.GET })
	public String initTbStAjdjxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajdj/listtbstajdjxx";
	}
	/**
	 * 案件登记信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@SysControllerLog(desc = "案件登记信息分页查询")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/getTbStAjdjxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjdjxxByPage(
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
	*显示案件登记信息新增页面
	**/
	@SysControllerLog(desc = "显示案件登记信息新增页面")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/initAddTbStAjdjxxPage", method = { RequestMethod.GET })
	public ModelAndView initAddTbStAjdjxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		String ajbh = comService.getYwbh("A", BspUtils.getLoginUser().getOrganCode());
		ModelAndView mv = new ModelAndView();
		mv.addObject("ajbh", ajbh);
		mv.setViewName("jsp/ywbl/ajdj/edittbstajdjxx");
		return mv;
	}
	/**
	*显示案件登记信息修改页面
	**/
	@SysControllerLog(desc = "显示案件登记信息修改页面")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/initEditTbStAjdjxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjdjxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajdj/edittbstajdjxx";
	}
	/**
	*显示案件登记信息详细页面
	**/
	@SysControllerLog(desc = "显示案件登记信息详细页面")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/initDetailTbStAjdjxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjdjxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajdj/detailtbstajdjxx";
	}
	/**
	*显示案件登记信息列表页面
	**/
	@SysControllerLog(desc = "显示案件登记Main页面")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/initAjxxmainPage", method = { RequestMethod.GET })
	public String initAjxxmainPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/ajdj/ajxxmain";
	}
	/**
	*保存新增/修改案件登记信息
	**/
	@SysControllerLog(desc = "保存新增/修改案件登记信息")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/saveAddEditTbStAjdjxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjdjxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStAjdjxx edit = (TbStAjdjxx) getEntityBean(request,TbStAjdjxx.class);
			tbstajdjxxService.saveAddEditTbStAjdjxx(edit);
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
	*删除案件登记信息
	**/
	@SysControllerLog(desc = "删除案件登记信息")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/delTbStAjdjxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjdjxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStAjdjxx.class);
			tbstajdjxxService.delTbStAjdjxxById(de);
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
	*根据主键查询案件登记信息
	**/
	@SysControllerLog(desc = "根据主键查询案件登记信息")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/getTbStAjdjxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjdjxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjdjxx bean = tbstajdjxxService.getTbStAjdjxxById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	*根据主键查询案件登记信息
	**/
	@SysControllerLog(desc = "根据案件编号查询案件登记信息")
	@RequestMapping(value = "/ywbl/TbStAjdjxx/getTbStAjdjxxByAjbh", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjdjxxByAjbh(
			HttpServletRequest request, 
			HttpServletResponse response){
		String ajbh = request.getParameter("ajbh");
		TbStAjdjxx bean = tbstajdjxxService.getTbStAjdjxxByAjbh(ajbh);
		return JsonUtils.obj2json(bean);
	}
}