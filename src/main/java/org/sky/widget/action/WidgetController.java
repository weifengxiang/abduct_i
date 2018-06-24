package org.sky.widget.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.action.BaseController;
import org.sky.sys.utils.ResultData;
import org.sky.widget.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @ClassName:  WidgetController   
 * @Description:TODO(微件)   
 * @author: weifx 
 * @date:   2018年6月17日 上午9:34:59   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class WidgetController extends BaseController{
	@Autowired
	private WidgetService wgService;
	/**
	 * 地区案件登记统计
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/widget/WidgetController/selectAjArea", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectAjArea(
			HttpServletRequest request, 
			HttpServletResponse response){
		List<Map> list = wgService.selectAjArea();
		return list;
	} 
	/**
	 * 待办信息
	 */
	@RequestMapping(value = "/widget/WidgetController/selectDbxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectDbxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		List<Map> list = wgService.selectDbxx();
		return list;
	} 
	/**
	 * 报警方式
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/widget/WidgetController/selectBjfs", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectBjfs(
			HttpServletRequest request, 
			HttpServletResponse response){
		List<Map> list = wgService.selectBjfs();
		return list;
	} 
}
