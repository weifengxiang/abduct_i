package org.sky.tjfx.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.action.BaseController;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.StringUtils;
import org.sky.tjfx.service.TjfxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sms.SendMessage;
/**
 * 
 * @ClassName:  TjfxController   
 * @Description:TODO(统计分析)   
 * @author: weifx 
 * @date:   2018年6月25日 上午10:56:51   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class TjfxController extends BaseController{
	@Autowired
	private TjfxService tjfxService;
	/**
	*案发量统计
	**/
	@RequestMapping(value = "/tjfx/TjfxController/initAfltjListPage", method = { RequestMethod.GET })
	public String initAfltjListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/afltj/afltjlist";
	}
	/**
	 * 案发量统计
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tjfx/TjfxController/selectAfl", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectAfl(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectAfl(ft);
		return list;
	}
	/**
	*案发量统计
	**/
	@RequestMapping(value = "/tjfx/TjfxController/initSzddListPage", method = { RequestMethod.GET })
	public String initSzddListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/szddtj/szddlist";
	}
	/**
	 * 失踪地点
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tjfx/TjfxController/selectSzdd", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectSzdd(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectSzdd(ft);
		return list;
	}
	/**
	 * 工作量统计页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tjfx/TjfxController/initGzltjListPage", method = { RequestMethod.GET })
	public String initGzltjListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/gzltj/gzltjlist";
	}
	/**
	 * 工作量查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tjfx/TjfxController/selectGzl", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectGzl(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectGzl(ft);
		return list;
	}
	//文字布控
	@RequestMapping(value = "/tjfx/TjfxController/initWzbktjListPage", method = { RequestMethod.GET })
	public String initWzbktjListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/wzbktj/wzbktjlist";
	}
	@RequestMapping(value = "/tjfx/TjfxController/selectWzbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectWzbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectWzbk(ft);
		return list;
	}
	//图像布控
	@RequestMapping(value = "/tjfx/TjfxController/initTxbktjListPage", method = { RequestMethod.GET })
	public String initTxbktjListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/txbktj/txbktjlist";
	}
	//图像布控查询
	@RequestMapping(value = "/tjfx/TjfxController/selectTxbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectTxbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectTxbk(ft);
		return list;
	}
	//视频布控
	@RequestMapping(value = "/tjfx/TjfxController/initSpbktjListPage", method = { RequestMethod.GET })
	public String initSpbktjListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/tjfx/spbktj/spbktjlist";
	}
	@RequestMapping(value = "/tjfx/TjfxController/selectSpbk", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Map> selectSpbk(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map ft = new HashMap();
		if(!StringUtils.isNull(filter)) {
			ft = JsonUtils.json2map(filter);
		}
		List<Map> list = tjfxService.selectSpbk(ft);
		return list;
	}
}
