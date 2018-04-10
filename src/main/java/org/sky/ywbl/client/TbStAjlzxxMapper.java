package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjlzxx;
import org.sky.ywbl.model.TbStAjlzxxExample;

public interface TbStAjlzxxMapper {
    long countByExample(TbStAjlzxxExample example);

    int deleteByExample(TbStAjlzxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjlzxx record);

    int insertSelective(TbStAjlzxx record);

    List<TbStAjlzxx> selectByExample(TbStAjlzxxExample example);

    TbStAjlzxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjlzxx record, @Param("example") TbStAjlzxxExample example);

    int updateByExample(@Param("record") TbStAjlzxx record, @Param("example") TbStAjlzxxExample example);

    int updateByPrimaryKeySelective(TbStAjlzxx record);

    int updateByPrimaryKey(TbStAjlzxx record);
}