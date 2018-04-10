package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjjaxx;
import org.sky.ywbl.model.TbStAjjaxxExample;

public interface TbStAjjaxxMapper {
    long countByExample(TbStAjjaxxExample example);

    int deleteByExample(TbStAjjaxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjjaxx record);

    int insertSelective(TbStAjjaxx record);

    List<TbStAjjaxx> selectByExample(TbStAjjaxxExample example);

    TbStAjjaxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjjaxx record, @Param("example") TbStAjjaxxExample example);

    int updateByExample(@Param("record") TbStAjjaxx record, @Param("example") TbStAjjaxxExample example);

    int updateByPrimaryKeySelective(TbStAjjaxx record);

    int updateByPrimaryKey(TbStAjjaxx record);
}