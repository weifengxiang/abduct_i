package org.sky.txbk.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.txbk.model.TbStTxbk;
import org.sky.txbk.model.TbStTxbkExample;
import org.sky.txbk.model.TbStTxbkExample.Criteria;
import org.sky.txbk.service.TbStTxbkService;
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
public class TbStTxbkController extends BaseController{
	@Autowired
	private TbStTxbkService tbsttxbkService;
	@Autowired
	private ComService comService;
	public TbStTxbkController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示图像布控列表页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/initTbStTxbkListPage", method = { RequestMethod.GET })
	public String initTbStTxbkListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/listtbsttxbk";
	}
	/**
	 * 图像布控分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/txbk/TbStTxbk/getTbStTxbkByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxbkByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStTxbkExample pote= new TbStTxbkExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbsttxbkService.getTbStTxbkByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示图像布控新增页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/initAddTbStTxbkPage", method = { RequestMethod.GET })
	public ModelAndView initAddTbStTxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String txbh = comService.getYwbh("T",BspUtils.getLoginUser().getCode(), BspUtils.getLoginUser().getOrganCode());
		mv.addObject("txbh",txbh);
		mv.setViewName("jsp/txbk/edittbsttxbk");
		return mv;
	}
	/**
	*显示图像布控修改页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/initEditTbStTxbkPage", method = { RequestMethod.GET })
	public String initEditTbStTxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/edittbsttxbk";
	}
	/**
	*显示图像布控详细页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/initDetailTbStTxbkPage", method = { RequestMethod.GET })
	public String initDetailTbStTxbkPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/detailtbsttxbk";
	}
	/**
	*保存新增/修改图像布控
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/saveAddEditTbStTxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStTxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStTxbk edit = (TbStTxbk) getEntityBean(request,TbStTxbk.class);
			tbsttxbkService.saveAddEditTbStTxbk(edit);
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
	*删除图像布控
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/delTbStTxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStTxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStTxbk.class);
			tbsttxbkService.delTbStTxbkById(de);
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
	*根据主键查询图像布控
	**/
	@RequestMapping(value = "/txbk/TbStTxbk/getTbStTxbkById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxbkById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStTxbk bean = tbsttxbkService.getTbStTxbkById(id);
		return JsonUtils.obj2json(bean);
	}
}