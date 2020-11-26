package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.GasFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasFaultMapper {
    long countByExample(GasFaultExample example);

    int deleteByExample(GasFaultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasFault record);

    int insertSelective(GasFault record);

    List<GasFault> selectByExample(GasFaultExample example);

    GasFault selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasFault record, @Param("example") GasFaultExample example);

    int updateByExample(@Param("record") GasFault record, @Param("example") GasFaultExample example);

    int updateByPrimaryKeySelective(GasFault record);

    int updateByPrimaryKey(GasFault record);
}