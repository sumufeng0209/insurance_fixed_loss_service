package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface DamageOfGoodsMapper {
    Map<String,Object> findByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
    Map<String,Object> findById(@Param("damage_of_goods_id") String damage_of_goods_id);
}
