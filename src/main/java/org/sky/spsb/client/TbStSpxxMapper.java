package org.sky.spsb.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.spsb.model.TbStSpxx;
import org.sky.spsb.model.TbStSpxxExample;

public interface TbStSpxxMapper {
    long countByExample(TbStSpxxExample example);

    int deleteByExample(TbStSpxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStSpxx record);

    int insertSelective(TbStSpxx record);

    List<TbStSpxx> selectByExample(TbStSpxxExample example);

    TbStSpxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStSpxx record, @Param("example") TbStSpxxExample example);

    int updateByExample(@Param("record") TbStSpxx record, @Param("example") TbStSpxxExample example);

    int updateByPrimaryKeySelective(TbStSpxx record);

    int updateByPrimaryKey(TbStSpxx record);
}