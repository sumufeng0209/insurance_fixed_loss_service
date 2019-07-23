package org.java.service;


import java.util.Map;

public interface DamageOfGoodsService {

    Map<String,Object> findByProcessInstanceId(String damage_of_goods_id);
}
