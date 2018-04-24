package org.sky.sjzq.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.sjzq.model.TbStSjzq;
import org.sky.sjzq.model.TbStSjzqExample;

public interface TbStSjzqMapper {
    long countByExample(TbStSjzqExample example);

    int deleteByExample(TbStSjzqExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStSjzq record);

    int insertSelective(TbStSjzq record);

    List<TbStSjzq> selectByExample(TbStSjzqExample example);

    TbStSjzq selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStSjzq record, @Param("example") TbStSjzqExample example);

    int updateByExample(@Param("record") TbStSjzq record, @Param("example") TbStSjzqExample example);

    int updateByPrimaryKeySelective(TbStSjzq record);

    int updateByPrimaryKey(TbStSjzq record);
}