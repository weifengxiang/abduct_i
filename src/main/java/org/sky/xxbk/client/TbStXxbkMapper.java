package org.sky.xxbk.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.xxbk.model.TbStXxbk;
import org.sky.xxbk.model.TbStXxbkExample;

public interface TbStXxbkMapper {
    long countByExample(TbStXxbkExample example);

    int deleteByExample(TbStXxbkExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStXxbk record);

    int insertSelective(TbStXxbk record);

    List<TbStXxbk> selectByExample(TbStXxbkExample example);

    TbStXxbk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStXxbk record, @Param("example") TbStXxbkExample example);

    int updateByExample(@Param("record") TbStXxbk record, @Param("example") TbStXxbkExample example);

    int updateByPrimaryKeySelective(TbStXxbk record);

    int updateByPrimaryKey(TbStXxbk record);
}