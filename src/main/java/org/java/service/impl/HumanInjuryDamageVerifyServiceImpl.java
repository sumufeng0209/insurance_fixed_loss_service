package org.java.service.impl;

import org.java.dao.HumanInjuryDamageVerifyMapper;
import org.java.service.HumanInjuryDamageVerifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class HumanInjuryDamageVerifyServiceImpl implements HumanInjuryDamageVerifyService {
    @Autowired
    private HumanInjuryDamageVerifyMapper humanInjuryDamageVerifyMapper;
    @Override
    public void audit(Map<String, Object> map) {
        humanInjuryDamageVerifyMapper.audit(map);
    }
}
