package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasRealtimeData;
import com.anfu.gas.pojo.GasRealtimeDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasRealtimeDataMapper {
    long countByExample(GasRealtimeDataExample example);

    int deleteByExample(GasRealtimeDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GasRealtimeData record);

    int insertSelective(GasRealtimeData record);

    List<GasRealtimeData> selectByExample(GasRealtimeDataExample example);

    GasRealtimeData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GasRealtimeData record, @Param("example") GasRealtimeDataExample example);

    int updateByExample(@Param("record") GasRealtimeData record, @Param("example") GasRealtimeDataExample example);

    int updateByPrimaryKeySelective(GasRealtimeData record);

    int updateByPrimaryKey(GasRealtimeData record);
}