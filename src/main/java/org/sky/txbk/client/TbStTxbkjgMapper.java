package org.sky.txbk.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.txbk.model.TbStTxbkjg;
import org.sky.txbk.model.TbStTxbkjgExample;

public interface TbStTxbkjgMapper {
    long countByExample(TbStTxbkjgExample example);

    int deleteByExample(TbStTxbkjgExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStTxbkjg record);

    int insertSelective(TbStTxbkjg record);

    List<TbStTxbkjg> selectByExample(TbStTxbkjgExample example);

    TbStTxbkjg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStTxbkjg record, @Param("example") TbStTxbkjgExample example);

    int updateByExample(@Param("record") TbStTxbkjg record, @Param("example") TbStTxbkjgExample example);

    int updateByPrimaryKeySelective(TbStTxbkjg record);

    int updateByPrimaryKey(TbStTxbkjg record);
}