package org.sky.tjfx.client;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
public interface TjfxMapper {
	//案发量查询
	public List<Map> selectAfl(@Param("filter")Map filter);
	//工作量查询
	public List<Map> selectGzl(@Param("filter")Map filter);
	//失踪地点统计
	public List<Map> selectSzdd(@Param("filter")Map filter);
	//文字布控统计
	public List<Map> selectWzbk(@Param("filter")Map filter);
	//图像布控
	public List<Map> selectTxbk(@Param("filter")Map filter);
	//视频布控
	public List<Map> selectSpbk(@Param("filter")Map filter);
}
