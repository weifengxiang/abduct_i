package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.sky.ywbl.model.TbStAjshxx;
import org.sky.ywbl.model.TbStAjshxxExample;
import org.sky.ywbl.service.TbStAjshxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 
 * @ClassName:  TbStAjjashxxController   
 * @Description:TODO(结案审核信息)   
 * @author: weifx 
 * @date:   2018年4月23日 下午9:26:31   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TbStAjjashxxController extends BaseController{
	@Autowired
	private TbStAjshxxService tbstajshxxService;
	
	public TbStAjjashxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件结案审核信息列表页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initTbStAjjashxxListPage", method = { RequestMethod.GET })
	public String initTbStAjjashxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/listtbstajjashxx";
	}
	/**
	 * 案件结案审核信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ywbl/TbStAjjashxx/getTbStAjjashxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjashxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjshxxExample pote= new TbStAjshxxExample();
		if(null!=filterMap){
			filterMap.put("ywlx@=","JASH");
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
	*显示案件结案审核信息新增页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initAddTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initAddTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/edittbstajjashxx";
	}
	/**
	*显示案件结案审核信息修改页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initEditTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/edittbstajjashxx";
	}
	/**
	*显示案件结案审核信息详细页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initDetailTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/detailtbstajjashxx";
	}
	/**
	*保存新增/修改案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/saveAddEditTbStAjjashxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjjashxx(
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
	*删除案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/delTbStAjjashxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjjashxx(
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
	*根据主键查询案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/getTbStAjjashxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjashxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjshxx bean = tbstajshxxService.getTbStAjshxxById(id);
		return JsonUtils.obj2json(bean);
	}
}