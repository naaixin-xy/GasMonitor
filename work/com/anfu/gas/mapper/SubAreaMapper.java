package com.anfu.gas.mapper;

import com.anfu.gas.pojo.SubArea;
import com.anfu.gas.pojo.SubAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubAreaMapper {
    long countByExample(SubAreaExample example);

    int deleteByExample(SubAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubArea record);

    int insertSelective(SubArea record);

    List<SubArea> selectByExample(SubAreaExample example);

    SubArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubArea record, @Param("example") SubAreaExample example);

    int updateByExample(@Param("record") SubArea record, @Param("example") SubAreaExample example);

    int updateByPrimaryKeySelective(SubArea record);

    int updateByPrimaryKey(SubArea record);
}