package twm.mybatisdemo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import twm.mybatisdemo.pojo.DeviceAlarm;
import twm.mybatisdemo.pojo.DeviceAlarmExample;

public interface DeviceAlarmMapper {
    long countByExample(DeviceAlarmExample example);

    int deleteByExample(DeviceAlarmExample example);

    int deleteByPrimaryKey(Integer alarmId);

    int insert(DeviceAlarm record);

    int insertSelective(DeviceAlarm record);

    List<DeviceAlarm> selectByExample(DeviceAlarmExample example);

    DeviceAlarm selectByPrimaryKey(Integer alarmId);

    int updateByExampleSelective(@Param("record") DeviceAlarm record, @Param("example") DeviceAlarmExample example);

    int updateByExample(@Param("record") DeviceAlarm record, @Param("example") DeviceAlarmExample example);

    int updateByPrimaryKeySelective(DeviceAlarm record);

    int updateByPrimaryKey(DeviceAlarm record);
}