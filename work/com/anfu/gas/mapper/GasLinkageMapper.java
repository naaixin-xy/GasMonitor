package com.anfu.gas.mapper;

import com.anfu.gas.pojo.GasLinkage;
import com.anfu.gas.pojo.GasLinkageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasLinkageMapper {
    long countByExample(GasLinkageExample example);

    int deleteByExample(GasLinkageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GasLinkage record);

    int insertSelective(GasLinkage record);

    List<GasLinkage> selectByExample(GasLinkageExample example);

    GasLinkage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GasLinkage record, @Param("example") GasLinkageExample example);

    int updateByExample(@Param("record") GasLinkage record, @Param("example") GasLinkageExample example);

    int updateByPrimaryKeySelective(GasLinkage record);

    int updateByPrimaryKey(GasLinkage record);
}