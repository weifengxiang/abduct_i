package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStXsxx;
import org.sky.ywbl.model.TbStXsxxExample;

public interface TbStXsxxMapper {
    long countByExample(TbStXsxxExample example);

    int deleteByExample(TbStXsxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStXsxx record);

    int insertSelective(TbStXsxx record);

    List<TbStXsxx> selectByExample(TbStXsxxExample example);

    TbStXsxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStXsxx record, @Param("example") TbStXsxxExample example);

    int updateByExample(@Param("record") TbStXsxx record, @Param("example") TbStXsxxExample example);

    int updateByPrimaryKeySelective(TbStXsxx record);

    int updateByPrimaryKey(TbStXsxx record);
}