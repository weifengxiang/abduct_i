package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjlzjl;
import org.sky.ywbl.model.TbStAjlzjlExample;

public interface TbStAjlzjlMapper {
    long countByExample(TbStAjlzjlExample example);

    int deleteByExample(TbStAjlzjlExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjlzjl record);

    int insertSelective(TbStAjlzjl record);

    List<TbStAjlzjl> selectByExample(TbStAjlzjlExample example);

    TbStAjlzjl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjlzjl record, @Param("example") TbStAjlzjlExample example);

    int updateByExample(@Param("record") TbStAjlzjl record, @Param("example") TbStAjlzjlExample example);

    int updateByPrimaryKeySelective(TbStAjlzjl record);

    int updateByPrimaryKey(TbStAjlzjl record);
}