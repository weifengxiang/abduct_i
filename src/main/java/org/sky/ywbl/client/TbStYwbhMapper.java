package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStYwbh;
import org.sky.ywbl.model.TbStYwbhExample;

public interface TbStYwbhMapper {
    long countByExample(TbStYwbhExample example);

    int deleteByExample(TbStYwbhExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStYwbh record);

    int insertSelective(TbStYwbh record);

    List<TbStYwbh> selectByExample(TbStYwbhExample example);

    TbStYwbh selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStYwbh record, @Param("example") TbStYwbhExample example);

    int updateByExample(@Param("record") TbStYwbh record, @Param("example") TbStYwbhExample example);

    int updateByPrimaryKeySelective(TbStYwbh record);

    int updateByPrimaryKey(TbStYwbh record);
}