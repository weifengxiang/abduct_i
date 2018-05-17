package org.sky.xxbk.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.xxbk.model.TbStBkcx;
import org.sky.xxbk.model.TbStBkcxExample;

public interface TbStBkcxMapper {
    long countByExample(TbStBkcxExample example);

    int deleteByExample(TbStBkcxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStBkcx record);

    int insertSelective(TbStBkcx record);

    List<TbStBkcx> selectByExample(TbStBkcxExample example);

    TbStBkcx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStBkcx record, @Param("example") TbStBkcxExample example);

    int updateByExample(@Param("record") TbStBkcx record, @Param("example") TbStBkcxExample example);

    int updateByPrimaryKeySelective(TbStBkcx record);

    int updateByPrimaryKey(TbStBkcx record);
}