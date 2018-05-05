package org.sky.txsb.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.txsb.model.TbStTxsb;
import org.sky.txsb.model.TbStTxsbExample;

public interface TbStTxsbMapper {
    long countByExample(TbStTxsbExample example);

    int deleteByExample(TbStTxsbExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStTxsb record);

    int insertSelective(TbStTxsb record);

    List<TbStTxsb> selectByExample(TbStTxsbExample example);

    TbStTxsb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStTxsb record, @Param("example") TbStTxsbExample example);

    int updateByExample(@Param("record") TbStTxsb record, @Param("example") TbStTxsbExample example);

    int updateByPrimaryKeySelective(TbStTxsb record);

    int updateByPrimaryKey(TbStTxsb record);
}