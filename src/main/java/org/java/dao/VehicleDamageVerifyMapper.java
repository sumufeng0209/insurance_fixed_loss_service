package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Mapper
public interface VehicleDamageVerifyMapper {
    void audit(Map<String,Object> map);
}
