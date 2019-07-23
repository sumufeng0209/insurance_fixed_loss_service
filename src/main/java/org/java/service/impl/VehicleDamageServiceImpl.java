package org.java.service.impl;

import org.java.service.VehicleDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class VehicleDamageServiceImpl implements VehicleDamageService {
    @Autowired
    private VehicleDamageService vehicleDamageService;
    @Override
    public Map<String, Object> findByProcessInstanceId(String processInstanceId) {
        return vehicleDamageService.findByProcessInstanceId(processInstanceId);
    }
}
