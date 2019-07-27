package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface HumanInjuryDamageMapper {
    Map<String,Object> findByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
    Map<String,Object> findById(@Param("human_injury_damage_id") String human_injury_damage_id);
}
