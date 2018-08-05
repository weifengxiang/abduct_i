package org.sky.txbk.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.spsb.model.TbStSpTxWithBLOBs;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.txbk.model.TbStTxbkjg;
import org.sky.txbk.model.TbStTxbkjgExample;
import org.sky.txbk.model.TbStTxbkjgExample.Criteria;
import org.sky.txbk.service.TbStTxbkjgService;
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
public class TbStTxbkjgController extends BaseController{
	@Autowired
	private TbStTxbkjgService tbsttxbkjgService;
	
	public TbStTxbkjgController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示图像布控结果列表页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/initTbStTxbkjgListPage", method = { RequestMethod.GET })
	public String initTbStTxbkjgListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/listtbsttxbkjg";
	}
	/**
	 * 图像布控结果分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/txbk/TbStTxbkjg/getTbStTxbkjgByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxbkjgByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStTxbkjgExample pote= new TbStTxbkjgExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbsttxbkjgService.getTbStTxbkjgByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示图像布控结果新增页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/initAddTbStTxbkjgPage", method = { RequestMethod.GET })
	public String initAddTbStTxbkjgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/edittbsttxbkjg";
	}
	/**
	*显示图像布控结果修改页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/initEditTbStTxbkjgPage", method = { RequestMethod.GET })
	public String initEditTbStTxbkjgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/edittbsttxbkjg";
	}
	/**
	*显示图像布控结果详细页面
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/initDetailTbStTxbkjgPage", method = { RequestMethod.GET })
	public String initDetailTbStTxbkjgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txbk/detailtbsttxbkjg";
	}
	/**
	*保存新增/修改图像布控结果
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/saveAddEditTbStTxbkjg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStTxbkjg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStTxbkjg edit = (TbStTxbkjg) getEntityBean(request,TbStTxbkjg.class);
			tbsttxbkjgService.saveAddEditTbStTxbkjg(edit);
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
	*删除图像布控结果
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/delTbStTxbkjg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStTxbkjg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStTxbkjg.class);
			tbsttxbkjgService.delTbStTxbkjgById(de);
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
	*根据主键查询图像布控结果
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/getTbStTxbkjgById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxbkjgById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStTxbkjg bean = tbsttxbkjgService.getTbStTxbkjgById(id);
		return JsonUtils.obj2json(bean);
	}
	/**
	*添加到必中
	**/
	@RequestMapping(value = "/txbk/TbStTxbkjg/addBz", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String addBz(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String id=request.getParameter("id");
			TbStTxbkjg bz = new TbStTxbkjg();
			bz.setId(id);
			bz.setState("01");
			tbsttxbkjgService.saveAddEditTbStTxbkjg(bz);
			rd.setCode(ResultData.code_success);
			rd.setName("添加比中成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("添加比中失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
}