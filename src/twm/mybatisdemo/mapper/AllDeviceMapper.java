package twm.mybatisdemo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import twm.mybatisdemo.pojo.AllDevice;
import twm.mybatisdemo.pojo.AllDeviceExample;

public interface AllDeviceMapper {
    long countByExample(AllDeviceExample example);

    int deleteByExample(AllDeviceExample example);

    int deleteByPrimaryKey(Integer deviceId);

    int insert(AllDevice record);

    int insertSelective(AllDevice record);

    List<AllDevice> selectByExample(AllDeviceExample example);

    AllDevice selectByPrimaryKey(Integer deviceId);

    int updateByExampleSelective(@Param("record") AllDevice record, @Param("example") AllDeviceExample example);

    int updateByExample(@Param("record") AllDevice record, @Param("example") AllDeviceExample example);

    int updateByPrimaryKeySelective(AllDevice record);

    int updateByPrimaryKey(AllDevice record);
}