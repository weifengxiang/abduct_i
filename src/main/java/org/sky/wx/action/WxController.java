package org.sky.wx.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.action.BaseController;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.ResultData;
import org.sky.wx.service.WxService;
import org.sky.ywbl.model.TbStXsxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @ClassName:  WxController   
 * @Description:TODO(微信服务)   
 * @author: weifx 
 * @date:   2018年10月11日 下午6:15:27   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Controller
public class WxController extends BaseController{
	@Autowired
	private WxService wxService;
	
	@RequestMapping(value = "/gongzhonghao", method = { RequestMethod.GET })
	public String login(
			HttpServletRequest request, HttpServletResponse response) {
		return "wx/main";
	}
	
	@RequestMapping(value = "/wx/xsxx/addXsxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String addXsxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStXsxx edit = (TbStXsxx) getEntityBean(request,TbStXsxx.class);
			String dangerPicData=request.getParameter("dangerPicData");
			wxService.addXsxx(edit, dangerPicData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("保存失败<br>"+e.getMessage());
		}
		rd.setCode(ResultData.code_success);
		rd.setName("上传成功");
		return JsonUtils.obj2json(rd);
	}
}
