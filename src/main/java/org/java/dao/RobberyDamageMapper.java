package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Mapper
public interface RobberyDamageMapper {

    Map<String,Object> findByProcessInstanceId(@Param("processInstanceId") String processInstanceId);

    Map<String,Object> findById(@Param("robbery_damage_id") String robbery_damage_id);
}
