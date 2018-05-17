package org.sky.xxbk.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.xxbk.model.TbStXxbk;
import org.sky.xxbk.model.TbStXxbkExample;
import org.sky.xxbk.model.TbStXxbkExample.Criteria;
import org.sky.xxbk.service.TbStXxbkService;
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
public class TbStBkshController extends BaseController{
	@Autowired
	private TbStXxbkService tbstxxbkService;
	
	public TbStBkshController() {
		// TODO Auto-generated constructor stub
	}

}