package org.sky.ywbl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.ywbl.model.TbStAjdjxx;
import org.sky.ywbl.model.TbStAjdjxxExample;

public interface TbStAjdjxxMapper {
    long countByExample(TbStAjdjxxExample example);

    int deleteByExample(TbStAjdjxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjdjxx record);

    int insertSelective(TbStAjdjxx record);

    List<TbStAjdjxx> selectByExample(TbStAjdjxxExample example);

    TbStAjdjxx selectByPrimaryKey(String id);
    
    TbStAjdjxx selectByAjbh(String ajbh);

    int updateByExampleSelective(@Param("record") TbStAjdjxx record, @Param("example") TbStAjdjxxExample example);

    int updateByExample(@Param("record") TbStAjdjxx record, @Param("example") TbStAjdjxxExample example);

    int updateByPrimaryKeySelective(TbStAjdjxx record);

    int updateByPrimaryKey(TbStAjdjxx record);
}