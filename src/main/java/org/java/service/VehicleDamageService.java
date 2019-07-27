package org.java.service;

import java.util.Map;

public interface VehicleDamageService {

    Map<String,Object> findByProcessInstanceId(String processInstanceId);
    Map<String,Object> findById(String vehilce_damage_id);
}
