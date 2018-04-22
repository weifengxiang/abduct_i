package org.sky.ywbl.action;

import java.util.List;

import org.sky.log.SysControllerLog;
import org.sky.sys.action.BaseController;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @ClassName:  CommonController   
 * @Description:TODO(通用服务)   
 * @author: weifx 
 * @date:   2018年4月22日 下午3:36:49   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ComController extends BaseController {
	@Autowired
	private ComService comService;
	@SysControllerLog(desc = "显示图像")
	@RequestMapping(value = "/ywbl/com/viewTxxx/{ywlx}/{ywbh}", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody List<TbStTxxx> viewTxxx(
			@PathVariable String ywlx,
			@PathVariable String ywbh
			) {
		return comService.selectTxxxByYW(ywlx, ywbh);
	}

}
