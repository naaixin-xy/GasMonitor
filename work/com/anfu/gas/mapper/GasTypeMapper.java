package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasType;
import com.anfu.gas.pojo.GasTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTypeMapper {
    long countByExample(GasTypeExample example);

    int deleteByExample(GasTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasType record);

    int insertSelective(GasType record);

    List<GasType> selectByExample(GasTypeExample example);

    GasType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasType record, @Param("example") GasTypeExample example);

    int updateByExample(@Param("record") GasType record, @Param("example") GasTypeExample example);

    int updateByPrimaryKeySelective(GasType record);

    int updateByPrimaryKey(GasType record);
}