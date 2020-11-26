package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDetectorMapper {
    long countByExample(GasDetectorExample example);

    int deleteByExample(GasDetectorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasDetector record);

    int insertSelective(GasDetector record);

    List<GasDetector> selectByExample(GasDetectorExample example);

    GasDetector selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasDetector record, @Param("example") GasDetectorExample example);

    int updateByExample(@Param("record") GasDetector record, @Param("example") GasDetectorExample example);

    int updateByPrimaryKeySelective(GasDetector record);

    int updateByPrimaryKey(GasDetector record);
}