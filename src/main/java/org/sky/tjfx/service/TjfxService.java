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
	/**
	 * 文字布控
	 * @param filter
	 * @return
	 */
	public List<Map> selectWzbk(Map filter){
		List list = null;
		list = tjfxMapper.selectWzbk(filter);
		return list;
	}
	/**
	 * 图像布控
	 * @param filter
	 * @return
	 */
	public List<Map> selectTxbk(Map filter){
		List list = null;
		list = tjfxMapper.selectTxbk(filter);
		return list;
	}
	/**
	 * 视频布控
	 * @param filter
	 * @return
	 */
	public List<Map> selectSpbk(Map filter){
		List list = null;
		list = tjfxMapper.selectSpbk(filter);
		return list;
	}
}
