package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface RepairProjectMapper {
    List<Map<String,Object>> findByVehilceDamageId(@Param("vehilce_damage_id") String vehilce_damage_id);
}
