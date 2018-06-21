package org.sky.hdjl.client;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sky.hdjl.model.TbStHdjlFs;
import org.sky.hdjl.model.TbStHdjlFsExample;

public interface TbStHdjlFsMapper {
    long countByExample(TbStHdjlFsExample example);

    int deleteByExample(TbStHdjlFsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbStHdjlFs record);

    int insertSelective(TbStHdjlFs record);

    List<TbStHdjlFs> selectByExample(TbStHdjlFsExample example);

    TbStHdjlFs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbStHdjlFs record, @Param("example") TbStHdjlFsExample example);

    int updateByExample(@Param("record") TbStHdjlFs record, @Param("example") TbStHdjlFsExample example);

    int updateByPrimaryKeySelective(TbStHdjlFs record);

    int updateByPrimaryKey(TbStHdjlFs record);
}