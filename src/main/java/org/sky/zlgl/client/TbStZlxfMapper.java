package org.sky.zlgl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.zlgl.model.TbStZlxf;
import org.sky.zlgl.model.TbStZlxfExample;

public interface TbStZlxfMapper {
    long countByExample(TbStZlxfExample example);

    int deleteByExample(TbStZlxfExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStZlxf record);

    int insertSelective(TbStZlxf record);

    List<TbStZlxf> selectByExample(TbStZlxfExample example);

    TbStZlxf selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStZlxf record, @Param("example") TbStZlxfExample example);

    int updateByExample(@Param("record") TbStZlxf record, @Param("example") TbStZlxfExample example);

    int updateByPrimaryKeySelective(TbStZlxf record);

    int updateByPrimaryKey(TbStZlxf record);
}