package org.sky.xxbk.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.xxbk.service.TbStXxbkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
@Controller
public class TbStBkshController extends BaseController{
	@Autowired
	private TbStXxbkService tbstxxbkService;
	
	public TbStBkshController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示布控审核查询列表页面
	**/
	@RequestMapping(value = "/bksh/TbStBksh/initTbStBkshListPage", method = { RequestMethod.GET })
	public String initTbStBkshListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/xxbk/bksh/listtbstbksh";
	}
}