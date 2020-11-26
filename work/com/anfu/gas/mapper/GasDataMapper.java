package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDataMapper {
    long countByExample(GasDataExample example);

    int deleteByExample(GasDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasData record);

    int insertSelective(GasData record);

    List<GasData> selectByExample(GasDataExample example);

    GasData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasData record, @Param("example") GasDataExample example);

    int updateByExample(@Param("record") GasData record, @Param("example") GasDataExample example);

    int updateByPrimaryKeySelective(GasData record);

    int updateByPrimaryKey(GasData record);
}