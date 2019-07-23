package org.java.service.impl;

import org.java.dao.VehicleDamageVerifyMapper;
import org.java.service.VehicleDamageVerifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class VehicleDamageVerifyServiceImpl implements VehicleDamageVerifyService {
    @Autowired
    private VehicleDamageVerifyMapper vehicleDamageVerifyMapper;

    @Override
    public void audit(Map<String, Object> map) {
        vehicleDamageVerifyMapper.audit(map);
    }
}
