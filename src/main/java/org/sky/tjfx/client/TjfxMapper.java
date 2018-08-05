package org.sky.tjfx.client;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
public interface TjfxMapper {
	//案发量查询
	public List<Map> selectAfl(@Param("filter")Map filter);
	//工作量查询
	public List<Map> selectGzl(@Param("filter")Map filter);

	public List<Map> selectSzdd(@Param("filter")Map filter);
}
