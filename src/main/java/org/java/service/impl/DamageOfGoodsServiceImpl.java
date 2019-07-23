package org.java.service.impl;

import org.java.dao.DamageOfGoodsMapper;
import org.java.service.DamageOfGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DamageOfGoodsServiceImpl implements DamageOfGoodsService {

    @Autowired
    DamageOfGoodsMapper damageOfGoodsMapper;

    @Override
    public Map<String, Object> findByProcessInstanceId(String processInstanceId) {
        return damageOfGoodsMapper.findByProcessInstanceId(processInstanceId);
    }
}
