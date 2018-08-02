package org.sky.zhcx.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.log.SysControllerLog;
import org.sky.sys.action.BaseController;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.StringUtils;
import org.sky.ywbl.model.TbStAjdjxxExample;
import org.sky.zhcx.service.ZhcxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName:  ZhcxController   
 * @Description:TODO(综合查询)   
 * @author: weifx 
 * @date:   2018年6月16日 下午10:10:05   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class ZhcxController extends BaseController{
	@Autowired
	private ZhcxService zhcxServive;
	//案件查询
	@RequestMapping(value = "/zhcx/ajcx/initAjcxPage", method = { RequestMethod.GET })
	public String initAjcxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zhcx/ajcx/ajcx";
	}
	//线索查询
	@RequestMapping(value = "/zhcx/xscx/initXscxPage", method = { RequestMethod.GET })
	public String initXscxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zhcx/xscx/xscx";
	}
	//数据抓取
	@RequestMapping(value = "/zhcx/sjzq/initZqcxPage", method = { RequestMethod.GET })
	public String initZqcxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/zhcx/sjzq/zqcx";
	}
	@SysControllerLog(desc = "案件登记信息分页查询")
	@RequestMapping(value = "/zhcx/ajcx/getTbStAjdjxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjdjxxByPage (
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjdjxxExample pote= new TbStAjdjxxExample();
		if(null==filterMap) {
			filterMap=new HashMap();
		}
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = zhcxServive.getTbStAjdjxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
}
