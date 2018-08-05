package org.sky.tjfx.service;

import java.util.List;
import java.util.Map;

import org.sky.tjfx.client.TjfxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TjfxService {
	@Autowired
	private TjfxMapper tjfxMapper;
	/**
	 * 统计案发量
	 * @param filter
	 * @return
	 */
	public List<Map> selectAfl(Map filter){
		List list = null;
		list = tjfxMapper.selectAfl(filter);
		return list;
	}
	/**
	 * 统计工作量
	 * @param filter
	 * @return
	 */
	public List<Map> selectGzl(Map filter){
		List list = null;
		list = tjfxMapper.selectGzl(filter);
		return list;
	}
	/**
	 * 失踪地点统计
	 * @param filter
	 * @return
	 */
	public List<Map> selectSzdd(Map filter){
		List list = null;
		list = tjfxMapper.selectSzdd(filter);
		return list;
	}
}
