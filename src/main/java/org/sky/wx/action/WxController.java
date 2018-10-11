package org.sky.wx.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class WxController {
	@RequestMapping(value = "/gongzhonghao/", method = { RequestMethod.GET })
	public String login(
			HttpServletRequest request, HttpServletResponse response) {
		return "wx/main";
	}
}
