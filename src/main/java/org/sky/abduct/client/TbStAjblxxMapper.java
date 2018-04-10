package org.sky.abduct.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.abduct.model.TbStAjblxx;
import org.sky.abduct.model.TbStAjblxxExample;

public interface TbStAjblxxMapper {
    long countByExample(TbStAjblxxExample example);

    int deleteByExample(TbStAjblxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStAjblxx record);

    int insertSelective(TbStAjblxx record);

    List<TbStAjblxx> selectByExample(TbStAjblxxExample example);

    TbStAjblxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStAjblxx record, @Param("example") TbStAjblxxExample example);

    int updateByExample(@Param("record") TbStAjblxx record, @Param("example") TbStAjblxxExample example);

    int updateByPrimaryKeySelective(TbStAjblxx record);

    int updateByPrimaryKey(TbStAjblxx record);
}