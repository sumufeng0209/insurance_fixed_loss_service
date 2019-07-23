package org.java.service;

import java.util.Map;

public interface NuclearDamageService {
    Map<String,Object> showAll(Map<String,Object> paramMap);
    void audit(Map<String,Object> map);
}
