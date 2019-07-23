package org.java.service;



import java.util.Map;

public interface DamageOfGoodsService {

    Map<String,Object> findByProcessInstanceId(String processInstanceId);
    Map<String,Object> findById(String damage_of_goods_id);
}
