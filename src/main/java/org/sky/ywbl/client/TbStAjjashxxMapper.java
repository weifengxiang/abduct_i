package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjjashxx;
import org.sky.ywbl.model.TbStAjjashxxExample;

public interface TbStAjjashxxMapper {
    long countByExample(TbStAjjashxxExample example);

    int deleteByExample(TbStAjjashxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjjashxx record);

    int insertSelective(TbStAjjashxx record);

    List<TbStAjjashxx> selectByExample(TbStAjjashxxExample example);

    TbStAjjashxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjjashxx record, @Param("example") TbStAjjashxxExample example);

    int updateByExample(@Param("record") TbStAjjashxx record, @Param("example") TbStAjjashxxExample example);

    int updateByPrimaryKeySelective(TbStAjjashxx record);

    int updateByPrimaryKey(TbStAjjashxx record);
}