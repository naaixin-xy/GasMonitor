package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasAlarmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasAlarmMapper {
    long countByExample(GasAlarmExample example);

    int deleteByExample(GasAlarmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasAlarm record);

    int insertSelective(GasAlarm record);

    List<GasAlarm> selectByExample(GasAlarmExample example);

    GasAlarm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasAlarm record, @Param("example") GasAlarmExample example);

    int updateByExample(@Param("record") GasAlarm record, @Param("example") GasAlarmExample example);

    int updateByPrimaryKeySelective(GasAlarm record);

    int updateByPrimaryKey(GasAlarm record);
}