package org.java.service.impl;

import org.java.dao.RepairProjectMapper;
import org.java.service.RepairProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepairProjectServiceImpl implements RepairProjectService {
    @Autowired
    private RepairProjectMapper repairProjectMapper;
    @Override
    public Map<String,Object> findByVehilceDamageId(String vehilce_damage_id) {
        List<Map<String,Object>> list = repairProjectMapper.findByVehilceDamageId(vehilce_damage_id);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("msg","");
        dataMap.put("data",list);
        dataMap.put("count",list.size());
        return dataMap;
    }
}
