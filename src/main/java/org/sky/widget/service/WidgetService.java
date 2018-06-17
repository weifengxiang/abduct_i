package org.sky.widget.service;

import java.util.List;
import java.util.Map;

import org.sky.ywbl.client.TbStAjdjxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WidgetService {
	@Autowired
	private TbStAjdjxxMapper djxxMapper;
	public List<Map> selectAjArea() {
		return djxxMapper.selectAjArea();
	}
}
