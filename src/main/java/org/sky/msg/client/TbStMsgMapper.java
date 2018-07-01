package org.sky.msg.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.msg.model.TbStMsg;
import org.sky.msg.model.TbStMsgExample;

public interface TbStMsgMapper {
    long countByExample(TbStMsgExample example);

    int deleteByExample(TbStMsgExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStMsg record);

    int insertSelective(TbStMsg record);

    List<TbStMsg> selectByExample(TbStMsgExample example);

    TbStMsg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStMsg record, @Param("example") TbStMsgExample example);

    int updateByExample(@Param("record") TbStMsg record, @Param("example") TbStMsgExample example);

    int updateByPrimaryKeySelective(TbStMsg record);

    int updateByPrimaryKey(TbStMsg record);
    
    void insertOrgMsg(@Param("orgCode")String orgCode,@Param("content")String content);
}