package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasHostType;
import com.anfu.gas.pojo.GasHostTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasHostTypeMapper {
    long countByExample(GasHostTypeExample example);

    int deleteByExample(GasHostTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasHostType record);

    int insertSelective(GasHostType record);

    List<GasHostType> selectByExample(GasHostTypeExample example);

    GasHostType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasHostType record, @Param("example") GasHostTypeExample example);

    int updateByExample(@Param("record") GasHostType record, @Param("example") GasHostTypeExample example);

    int updateByPrimaryKeySelective(GasHostType record);

    int updateByPrimaryKey(GasHostType record);
}