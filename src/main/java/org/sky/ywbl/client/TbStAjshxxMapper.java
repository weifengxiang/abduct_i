package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjshxx;
import org.sky.ywbl.model.TbStAjshxxExample;

public interface TbStAjshxxMapper {
    long countByExample(TbStAjshxxExample example);

    int deleteByExample(TbStAjshxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjshxx record);

    int insertSelective(TbStAjshxx record);

    List<TbStAjshxx> selectByExample(TbStAjshxxExample example);

    TbStAjshxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjshxx record, @Param("example") TbStAjshxxExample example);

    int updateByExample(@Param("record") TbStAjshxx record, @Param("example") TbStAjshxxExample example);

    int updateByPrimaryKeySelective(TbStAjshxx record);

    int updateByPrimaryKey(TbStAjshxx record);
}