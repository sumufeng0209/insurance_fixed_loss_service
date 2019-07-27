package org.java.service.impl;

import org.java.dao.ReplaceProjectMapper;
import org.java.service.ReplaceProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReplaceProjectServiceImpl implements ReplaceProjectService {

    @Autowired
    private ReplaceProjectMapper replaceProjectMapper;

    @Override
    public Map<String, Object> findByVehilceDamageId(String vehilce_damage_id) {
        List<Map<String,Object>> list = replaceProjectMapper.findByVehilceDamageId(vehilce_damage_id);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("code",0);
        dataMap.put("msg","");
        dataMap.put("count",list.size());
        dataMap.put("data",list);
        return null;
    }
}
