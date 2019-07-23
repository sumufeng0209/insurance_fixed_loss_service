package org.java.service.impl;

import org.java.dao.RobberyDamageMapper;
import org.java.service.RobberyDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class RobberyDamageServiceImpl implements RobberyDamageService {
    @Autowired
    private RobberyDamageMapper robberyDamageMapper;
    @Override
    public Map<String, Object> findByProcessInstanceId(String processInstanceId) {
        return robberyDamageMapper.findByProcessInstanceId(processInstanceId);
    }
}
