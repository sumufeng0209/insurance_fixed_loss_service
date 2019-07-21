package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FixedLossMapper {

    public List<Map> scheduleFindBy(Map m);
}
