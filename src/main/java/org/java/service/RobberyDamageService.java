package org.java.service;

import java.util.Map;

public interface RobberyDamageService {

    Map<String,Object> findByProcessInstanceId(String processInstanceId);

    Map<String,Object> findById(String robbery_damage_id);
}
