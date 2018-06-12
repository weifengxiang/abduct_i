package org.sky.xxbk.action;


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
import org.sky.xxbk.model.TbStBkcxExample;
import org.sky.xxbk.model.TbStXxbk;
import org.sky.xxbk.model.TbStXxbkExample;
import org.sky.xxbk.service.TbStXxbkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
@Controller
public class TbStBkshController extends BaseController{
	@Autowired
	private TbStXxbkService tbstxxbkService;
	
	public TbStBkshController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示布控审核查询列表页面
	**/
	@RequestMapping(value = "/bksh/TbStBksh/initTbStBkshListPage", method = { RequestMethod.GET })
	public String initTbStBkshListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bksh/listtbstbksh";
	}
	/**
	 * 信息布控分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bksh/TbStBksh/getTbStBkshByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStBkshByPage(
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
	 * 布控审核
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bksh/TbStBksh/shTbStXxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String shTbStXxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String zt = request.getParameter("zt");
			String shRows=request.getParameter("shRows");
			List<TbStXxbk> shList=JsonUtils.json2list(shRows, TbStXxbk.class);
			for(TbStXxbk bk:shList) {
				bk.setZt(zt);
			}
			tbstxxbkService.saveTbStXxbk(null, shList);
			rd.setCode(ResultData.code_success);
			rd.setName("审核成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("审核失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
}