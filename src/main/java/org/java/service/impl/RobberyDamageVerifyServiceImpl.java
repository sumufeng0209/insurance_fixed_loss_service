package org.java.service.impl;

import org.java.dao.RobberyDamageVerifyMapper;
import org.java.service.RobberyDamageVerifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class RobberyDamageVerifyServiceImpl implements RobberyDamageVerifyService {

    @Autowired
    private RobberyDamageVerifyMapper robberyDamageVerifyMapper;

    @Override
    public void audit(Map<String, Object> map) {
        robberyDamageVerifyMapper.audit(map);
    }
}
