package org.sky.widget.service;

import java.util.List;
import java.util.Map;

import org.sky.sys.utils.BspUtils;
import org.sky.widget.client.WidgetMapper;
import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WidgetService {
	@Autowired
	private TbStAjdjxxMapper djxxMapper;
	@Autowired
	private WidgetMapper widgetMapper;
	public List<Map> selectAjArea() {
		return djxxMapper.selectAjArea();
	}
	/**
	 * 待办信息查询
	 * @return
	 */
	public List<Map> selectDbxx(){
		String organCode = BspUtils.getLoginUser().getOrganCode();
		List list = widgetMapper.selectDbxx(organCode);
		return list;
	}
	/**
	 * 报警方式
	 * @return
	 */
	public List<Map> selectBjfs(){
		String organCode = BspUtils.getLoginUser().getOrganCode();
		List list = widgetMapper.selectBjfs();
		return list;
	}
}
