package org.sky.spsb.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.spsb.model.TbStSpTx;
import org.sky.spsb.model.TbStSpTxExample;
import org.sky.spsb.model.TbStSpTxExample.Criteria;
import org.sky.spsb.model.TbStSpTxWithBLOBs;
import org.sky.spsb.service.TbStSpTxService;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class TbStSpTxController extends BaseController{
	@Autowired
	private TbStSpTxService tbstsptxService;
	
	public TbStSpTxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示视频图片匹配列表页面
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/initTbStSpTxListPage", method = { RequestMethod.GET })
	public String initTbStSpTxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/listtbstsptx";
	}
	/**
	 * 视频图片匹配分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/spsb/TbStSpTx/getTbStSpTxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSpTxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStSpTxExample pote= new TbStSpTxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstsptxService.getTbStSpTxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示视频图片匹配新增页面
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/initAddTbStSpTxPage", method = { RequestMethod.GET })
	public String initAddTbStSpTxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/edittbstsptx";
	}
	/**
	*显示视频图片匹配修改页面
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/initEditTbStSpTxPage", method = { RequestMethod.GET })
	public String initEditTbStSpTxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/edittbstsptx";
	}
	/**
	*显示视频图片匹配详细页面
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/initDetailTbStSpTxPage", method = { RequestMethod.GET })
	public String initDetailTbStSpTxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/spsb/detailtbstsptx";
	}
	/**
	*保存新增/修改视频图片匹配
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/saveAddEditTbStSpTx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStSpTx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStSpTxWithBLOBs edit = (TbStSpTxWithBLOBs) getEntityBean(request,TbStSpTxWithBLOBs.class);
			String data = request.getParameter("data").replace("\"","");
			String txmc = request.getParameter("txmc");
			edit.setTxnr(data);
			edit.setWjmc(txmc);
			tbstsptxService.saveAddEditTbStSpTx(edit);
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
	*删除视频图片匹配
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/delTbStSpTx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStSpTx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStSpTx.class);
			tbstsptxService.delTbStSpTxById(de);
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
	*根据主键查询视频图片匹配
	**/
	@RequestMapping(value = "/spsb/TbStSpTx/getTbStSpTxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStSpTxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStSpTx bean = tbstsptxService.getTbStSpTxById(id);
		return JsonUtils.obj2json(bean);
	}
	@RequestMapping(value = "/spsb/TbStSpTx/viewImg/{id}", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String viewImg(
			@PathVariable String id,
			HttpServletRequest request, 
			HttpServletResponse response){
		TbStSpTxWithBLOBs bean = tbstsptxService.getTbStSpTxById(id);
		return "\""+bean.getTxnr()+"\"";
	}
	@RequestMapping(value = "/spsb/TbStSpTx/viewImgJt/{id}", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String viewImgJt(
			@PathVariable String id,
			HttpServletRequest request, 
			HttpServletResponse response){
		TbStSpTxWithBLOBs bean = tbstsptxService.getTbStSpTxById(id);
		return "\""+bean.getJt()+"\"";
	}
}