package org.sky.txbk.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.txbk.model.TbStTxbk;
import org.sky.txbk.model.TbStTxbkExample;

public interface TbStTxbkMapper {
    long countByExample(TbStTxbkExample example);

    int deleteByExample(TbStTxbkExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStTxbk record);

    int insertSelective(TbStTxbk record);

    List<TbStTxbk> selectByExample(TbStTxbkExample example);

    TbStTxbk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStTxbk record, @Param("example") TbStTxbkExample example);

    int updateByExample(@Param("record") TbStTxbk record, @Param("example") TbStTxbkExample example);

    int updateByPrimaryKeySelective(TbStTxbk record);

    int updateByPrimaryKey(TbStTxbk record);
}