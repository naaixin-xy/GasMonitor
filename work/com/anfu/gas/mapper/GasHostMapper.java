package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasHost;
import com.anfu.gas.pojo.GasHostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasHostMapper {
    long countByExample(GasHostExample example);

    int deleteByExample(GasHostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasHost record);

    int insertSelective(GasHost record);

    List<GasHost> selectByExample(GasHostExample example);

    GasHost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasHost record, @Param("example") GasHostExample example);

    int updateByExample(@Param("record") GasHost record, @Param("example") GasHostExample example);

    int updateByPrimaryKeySelective(GasHost record);

    int updateByPrimaryKey(GasHost record);
}