package org.sky.spsb.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.spsb.model.TbStSpTx;
import org.sky.spsb.model.TbStSpTxExample;
import org.sky.spsb.model.TbStSpTxWithBLOBs;

public interface TbStSpTxMapper {
    long countByExample(TbStSpTxExample example);

    int deleteByExample(TbStSpTxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStSpTxWithBLOBs record);

    int insertSelective(TbStSpTxWithBLOBs record);

    List<TbStSpTxWithBLOBs> selectByExampleWithBLOBs(TbStSpTxExample example);

    List<TbStSpTx> selectByExample(TbStSpTxExample example);

    TbStSpTxWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStSpTxWithBLOBs record, @Param("example") TbStSpTxExample example);

    int updateByExampleWithBLOBs(@Param("record") TbStSpTxWithBLOBs record, @Param("example") TbStSpTxExample example);

    int updateByExample(@Param("record") TbStSpTx record, @Param("example") TbStSpTxExample example);

    int updateByPrimaryKeySelective(TbStSpTxWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbStSpTxWithBLOBs record);

    int updateByPrimaryKey(TbStSpTx record);
}