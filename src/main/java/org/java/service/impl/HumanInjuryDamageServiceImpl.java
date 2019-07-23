package org.java.service.impl;

import org.java.dao.HumanInjuryDamageMapper;
import org.java.service.HumanInjuryDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HumanInjuryDamageServiceImpl implements HumanInjuryDamageService {
    @Autowired
    HumanInjuryDamageMapper humanInjuryDamageMapper;

    @Override
    public Map<String, Object> findByProcessInstanceId(String processInstanceId) {
        return humanInjuryDamageMapper.findByProcessInstanceId(processInstanceId);
    }

    @Override
    public Map<String, Object> findById(String human_injury_damage_id) {
        return humanInjuryDamageMapper.findById(human_injury_damage_id);
    }
}
