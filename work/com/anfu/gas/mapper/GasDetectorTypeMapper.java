package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasDetectorType;
import com.anfu.gas.pojo.GasDetectorTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDetectorTypeMapper {
    long countByExample(GasDetectorTypeExample example);

    int deleteByExample(GasDetectorTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasDetectorType record);

    int insertSelective(GasDetectorType record);

    List<GasDetectorType> selectByExample(GasDetectorTypeExample example);

    GasDetectorType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasDetectorType record, @Param("example") GasDetectorTypeExample example);

    int updateByExample(@Param("record") GasDetectorType record, @Param("example") GasDetectorTypeExample example);

    int updateByPrimaryKeySelective(GasDetectorType record);

    int updateByPrimaryKey(GasDetectorType record);
}