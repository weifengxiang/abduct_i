package org.sky.msg.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.msg.model.TbStMsg;
import org.sky.msg.model.TbStMsgExample;
import org.sky.msg.model.TbStMsgExample.Criteria;
import org.sky.msg.service.TbStMsgService;
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
public class TbStMsgController extends BaseController{
	@Autowired
	private TbStMsgService tbstmsgService;
	
	public TbStMsgController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示短信发送列表页面
	**/
	@RequestMapping(value = "/msg/TbStMsg/initTbStMsgListPage", method = { RequestMethod.GET })
	public String initTbStMsgListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/msg/listtbstmsg";
	}
	/**
	 * 短信发送分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/msg/TbStMsg/getTbStMsgByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStMsgByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStMsgExample pote= new TbStMsgExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstmsgService.getTbStMsgByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示短信发送新增页面
	**/
	@RequestMapping(value = "/msg/TbStMsg/initAddTbStMsgPage", method = { RequestMethod.GET })
	public String initAddTbStMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/msg/edittbstmsg";
	}
	/**
	*显示短信发送修改页面
	**/
	@RequestMapping(value = "/msg/TbStMsg/initEditTbStMsgPage", method = { RequestMethod.GET })
	public String initEditTbStMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/msg/edittbstmsg";
	}
	/**
	*显示短信发送详细页面
	**/
	@RequestMapping(value = "/msg/TbStMsg/initDetailTbStMsgPage", method = { RequestMethod.GET })
	public String initDetailTbStMsgPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/msg/detailtbstmsg";
	}
	/**
	*保存新增/修改短信发送
	**/
	@RequestMapping(value = "/msg/TbStMsg/saveAddEditTbStMsg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStMsg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStMsg edit = (TbStMsg) getEntityBean(request,TbStMsg.class);
			tbstmsgService.saveAddEditTbStMsg(edit);
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
	*删除短信发送
	**/
	@RequestMapping(value = "/msg/TbStMsg/delTbStMsg", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStMsg(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStMsg.class);
			tbstmsgService.delTbStMsgById(de);
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
	*根据主键查询短信发送
	**/
	@RequestMapping(value = "/msg/TbStMsg/getTbStMsgById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStMsgById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStMsg bean = tbstmsgService.getTbStMsgById(id);
		return JsonUtils.obj2json(bean);
	}
}