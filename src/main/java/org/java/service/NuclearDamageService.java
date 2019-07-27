package org.java.service;

import java.util.Map;

public interface NuclearDamageService {
    Map<String,Object> showAll(Map<String,Object> paramMap);
    void cheSunAudit(Map<String,Object> map);
    void daoQaingAudit(Map<String,Object> map);
}
