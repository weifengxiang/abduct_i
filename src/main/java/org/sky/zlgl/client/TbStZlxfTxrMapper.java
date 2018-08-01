package org.sky.zlgl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.zlgl.model.TbStZlxfTxr;
import org.sky.zlgl.model.TbStZlxfTxrExample;

public interface TbStZlxfTxrMapper {
    long countByExample(TbStZlxfTxrExample example);

    int deleteByExample(TbStZlxfTxrExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStZlxfTxr record);

    int insertSelective(TbStZlxfTxr record);

    List<TbStZlxfTxr> selectByExample(TbStZlxfTxrExample example);

    TbStZlxfTxr selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStZlxfTxr record, @Param("example") TbStZlxfTxrExample example);

    int updateByExample(@Param("record") TbStZlxfTxr record, @Param("example") TbStZlxfTxrExample example);

    int updateByPrimaryKeySelective(TbStZlxfTxr record);

    int updateByPrimaryKey(TbStZlxfTxr record);
}