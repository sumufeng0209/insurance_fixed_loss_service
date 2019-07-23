package org.java.service;

import java.util.Map;

public interface HumanInjuryDamageService {

    Map<String,Object> findByProcessInstanceId(String human_injury_damage_id);
}
