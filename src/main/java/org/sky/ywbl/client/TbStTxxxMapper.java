package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;

public interface TbStTxxxMapper {
    long countByExample(TbStTxxxExample example);

    int deleteByExample(TbStTxxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStTxxx record);

    int insertSelective(TbStTxxx record);

    List<TbStTxxx> selectByExampleWithBLOBs(TbStTxxxExample example);

    List<TbStTxxx> selectByExample(TbStTxxxExample example);

    TbStTxxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStTxxx record, @Param("example") TbStTxxxExample example);

    int updateByExampleWithBLOBs(@Param("record") TbStTxxx record, @Param("example") TbStTxxxExample example);

    int updateByExample(@Param("record") TbStTxxx record, @Param("example") TbStTxxxExample example);

    int updateByPrimaryKeySelective(TbStTxxx record);

    int updateByPrimaryKeyWithBLOBs(TbStTxxx record);

    int updateByPrimaryKey(TbStTxxx record);
}