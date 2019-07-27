package org.java.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@Mapper
public interface RepairProjectService {
    Map<String,Object> findByVehilceDamageId(String vehilce_damage_id);
}
