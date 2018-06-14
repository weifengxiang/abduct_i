package org.sky.zlgl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.zlgl.model.TbStZlfk;
import org.sky.zlgl.model.TbStZlfkExample;

public interface TbStZlfkMapper {
    long countByExample(TbStZlfkExample example);

    int deleteByExample(TbStZlfkExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStZlfk record);

    int insertSelective(TbStZlfk record);

    List<TbStZlfk> selectByExample(TbStZlfkExample example);

    TbStZlfk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStZlfk record, @Param("example") TbStZlfkExample example);

    int updateByExample(@Param("record") TbStZlfk record, @Param("example") TbStZlfkExample example);

    int updateByPrimaryKeySelective(TbStZlfk record);

    int updateByPrimaryKey(TbStZlfk record);
}