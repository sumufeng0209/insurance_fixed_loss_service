package org.java.service.impl;

import org.java.dao.DamageOfGoodsVerifyMapper;
import org.java.service.DamageOfGoodsVerifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DamageOfGoodsVerifyServiceImpl implements DamageOfGoodsVerifyService {

    @Autowired
    DamageOfGoodsVerifyMapper damageOfGoodsVerifyMapper;

    @Override
    public void audit(Map<String, Object> map) {
        damageOfGoodsVerifyMapper.audit(map);
    }
}
