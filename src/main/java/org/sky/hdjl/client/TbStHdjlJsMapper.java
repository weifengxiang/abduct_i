package org.sky.hdjl.client;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.sky.hdjl.model.TbStHdjlJs;
import org.sky.hdjl.model.TbStHdjlJsExample;

public interface TbStHdjlJsMapper {
    long countByExample(TbStHdjlJsExample example);

    int deleteByExample(TbStHdjlJsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStHdjlJs record);

    int insertSelective(TbStHdjlJs record);

    List<TbStHdjlJs> selectByExample(TbStHdjlJsExample example);

    TbStHdjlJs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStHdjlJs record, @Param("example") TbStHdjlJsExample example);

    int updateByExample(@Param("record") TbStHdjlJs record, @Param("example") TbStHdjlJsExample example);

    int updateByPrimaryKeySelective(TbStHdjlJs record);

    int updateByPrimaryKey(TbStHdjlJs record);
    /**
     * 查询用户接收到每个用户发送来的数据的数量
     * @param userCode
     * @return
     */
    List<Map> loadReceiverMsgCountByUser(String userCode);
}