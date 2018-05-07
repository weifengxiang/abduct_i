package org.sky.txsb.action;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.txsb.model.TbStTxsb;
import org.sky.txsb.model.TbStTxsbExample;
import org.sky.txsb.service.TbStTxsbService;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.ConfUtils;
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
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class TbStTxsbController extends BaseController{
	private final Logger logger=Logger.getLogger(TbStTxsbController.class);
	@Autowired
	private TbStTxsbService tbsttxsbService;
	
	public TbStTxsbController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示图像识别列表页面
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/initTbStTxsbListPage", method = { RequestMethod.GET })
	public String initTbStTxsbListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txsb/txsb/listtbsttxsb";
	}
	/**
	 * 图像识别分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/txsb/TbStTxsb/getTbStTxsbByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxsbByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStTxsbExample pote= new TbStTxsbExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbsttxsbService.getTbStTxsbByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示图像识别新增页面
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/initAddTbStTxsbPage", method = { RequestMethod.GET })
	public String initAddTbStTxsbPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txsb/txsb/edittbsttxsb";
	}
	/**
	*显示图像识别修改页面
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/initEditTbStTxsbPage", method = { RequestMethod.GET })
	public String initEditTbStTxsbPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txsb/txsb/edittbsttxsb";
	}
	/**
	*显示图像识别详细页面
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/initDetailTbStTxsbPage", method = { RequestMethod.GET })
	public String initDetailTbStTxsbPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/txsb/txsb/detailtbsttxsb";
	}
	/**
	*保存新增/修改图像识别
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/saveAddEditTbStTxsb", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStTxsb(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStTxsb edit = (TbStTxsb) getEntityBean(request,TbStTxsb.class);
			tbsttxsbService.saveAddEditTbStTxsb(edit);
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
	*删除图像识别
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/delTbStTxsb", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStTxsb(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStTxsb.class);
			tbsttxsbService.delTbStTxsbById(de);
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
	*根据主键查询图像识别
	**/
	@RequestMapping(value = "/txsb/TbStTxsb/getTbStTxsbById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStTxsbById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStTxsb bean = tbsttxsbService.getTbStTxsbById(id);
		return JsonUtils.obj2json(bean);
	}
}