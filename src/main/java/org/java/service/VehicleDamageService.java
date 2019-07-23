package org.java.service;

import java.util.Map;

public interface VehicleDamageService {

    Map<String,Object> findByProcessInstanceId(String vehilce_damage_id);
}
