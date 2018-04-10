package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjlcjl;
import org.sky.ywbl.model.TbStAjlcjlExample;

public interface TbStAjlcjlMapper {
    long countByExample(TbStAjlcjlExample example);

    int deleteByExample(TbStAjlcjlExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjlcjl record);

    int insertSelective(TbStAjlcjl record);

    List<TbStAjlcjl> selectByExample(TbStAjlcjlExample example);

    TbStAjlcjl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjlcjl record, @Param("example") TbStAjlcjlExample example);

    int updateByExample(@Param("record") TbStAjlcjl record, @Param("example") TbStAjlcjlExample example);

    int updateByPrimaryKeySelective(TbStAjlcjl record);

    int updateByPrimaryKey(TbStAjlcjl record);
}