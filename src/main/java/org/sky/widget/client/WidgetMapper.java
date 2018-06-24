package org.sky.widget.client;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WidgetMapper {
	//查询待办信息
	public List selectDbxx(String organCode);
	//查询报警方式
	public List selectBjfs();
}
