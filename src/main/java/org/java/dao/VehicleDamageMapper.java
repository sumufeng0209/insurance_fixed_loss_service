package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface VehicleDamageMapper {
    Map<String,Object> findByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
    Map<String,Object> findById(@Param("vehilce_damage_id") String vehilce_damage_id);
}
