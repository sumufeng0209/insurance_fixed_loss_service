package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.StringUtils;
import org.java.dao.*;
import org.java.service.NuclearDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class NuclearDamageServiceImpl implements NuclearDamageService {
    //物损定损
    @Autowired
    private DamageOfGoodsMapper damageOfGoodsMapper;
    //物损核损
    @Autowired
    private DamageOfGoodsVerifyMapper damageOfGoodsVerifyMapper;
    //人伤定损
    @Autowired
    private HumanInjuryDamageMapper humanInjuryDamageMapper;
    //人伤核损
    @Autowired
    private HumanInjuryDamageVerifyMapper humanInjuryDamageVerifyMapper;
    //盗抢定损
    @Autowired
    private RobberyDamageMapper robberyDamageMapper;
    //盗抢核损
    @Autowired
    private RobberyDamageVerifyMapper robberyDamageVerifyMapper;
    //车辆定损
    @Autowired
    private VehicleDamageMapper vehicleDamageMapper;
    //车辆核损
    @Autowired
    private VehicleDamageVerifyMapper vehicleDamageVerifyMapper;
    @Autowired
    private TaskService taskService;

    @Override
    public Map<String, Object> showAll(Map<String,Object> paramMap) {
        Map<String,Object> dataMap = new HashMap<>();
        TaskQuery query = taskService.createTaskQuery();
        query.taskAssignee(paramMap.get("userName").toString());
        List<Task> tasks = query.list();

        List<Map<String, Object>> list = new ArrayList<>();
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            Map<String,Object> map = null;

            if (task.getName().equals("车辆定损")){
                map = vehicleDamageMapper.findByProcessInstanceId(processInstanceId);
            }else if (task.getName().equals("盗抢查勘定损")){
                map = robberyDamageMapper.findByProcessInstanceId(processInstanceId);
            }

            if (map == null){
                continue;
            }

            map.put("instance_id",task.getProcessInstanceId());
            map.put("taskId",task.getId());//任务id
            map.put("taskName",task.getName());//任务名称
            map.put("createtime",task.getCreateTime());//任务的开始时间
            map.put("taskDefKey",task.getTaskDefinitionKey());//每一个任务对应的id的名称
            list.add(map);
        }
        dataMap.put("code",0);
        dataMap.put("msg","");
        dataMap.put("count",list.size());
        dataMap.put("data",list);
        return dataMap;
    }

    @Override
    public void cheSunAudit(Map<String, Object> map) {
        String taskId = map.get("taskId").toString();
        vehicleDamageVerifyMapper.audit(map);
        Map<String,Object> variables = new HashMap<>();
        variables.put("carAdopt",1); //设置流程变量
        taskService.complete(taskId,variables);
    }

    @Override
    public void daoQaingAudit(Map<String, Object> map) {
        String taskId = map.get("taskId").toString();
        robberyDamageVerifyMapper.audit(map);
        Map<String,Object> variables = new HashMap<>();
        variables.put("carAdopt",map.get("is_adopt")); //设置流程变量
        taskService.complete(taskId,variables);
    }
}
