package org.sky.abduct.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.abduct.model.TbStFjxx;
import org.sky.abduct.model.TbStFjxxExample;

public interface TbStFjxxMapper {
    long countByExample(TbStFjxxExample example);

    int deleteByExample(TbStFjxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStFjxx record);

    int insertSelective(TbStFjxx record);

    List<TbStFjxx> selectByExampleWithBLOBs(TbStFjxxExample example);

    List<TbStFjxx> selectByExample(TbStFjxxExample example);

    TbStFjxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStFjxx record, @Param("example") TbStFjxxExample example);

    int updateByExampleWithBLOBs(@Param("record") TbStFjxx record, @Param("example") TbStFjxxExample example);

    int updateByExample(@Param("record") TbStFjxx record, @Param("example") TbStFjxxExample example);

    int updateByPrimaryKeySelective(TbStFjxx record);

    int updateByPrimaryKeyWithBLOBs(TbStFjxx record);

    int updateByPrimaryKey(TbStFjxx record);
}