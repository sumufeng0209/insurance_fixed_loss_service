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

        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            String taskName = task.getName();
            Map map = null;
            if (taskName.equals("车辆定损核损")){
                map = vehicleDamageMapper.findByProcessInstanceId(processInstanceId);
            }else if (taskName.equals("人伤定损核损")){
                map = humanInjuryDamageMapper.findByProcessInstanceId(processInstanceId);
            }else if (taskName.equals("物损定损核损")){
                map = damageOfGoodsMapper.findByProcessInstanceId(processInstanceId);
            }else if (taskName.equals("盗抢定损核损")){
                map = robberyDamageMapper.findByProcessInstanceId(processInstanceId);
            }
            String compensate_case_id = map.get("compensate_case_id").toString();
            String schedule_id = map.get("schedule_id").toString();
            String insured_truename = map.get("insured_truename").toString();
            String car_number = map.get("car_number").toString();
            if (StringUtils.isNotBlank(paramMap.get("compensate_case_id").toString())){
                if (!compensate_case_id.equals(paramMap.get("compensate_case_id").toString())){
                    continue;
                }
            }else if (StringUtils.isNotBlank(paramMap.get("schedule_id").toString())){
                if (!schedule_id.equals(paramMap.get("schedule_id").toString())){
                    continue;
                }
            }else if (StringUtils.isNotBlank(paramMap.get("insured_truename").toString())){
                if (!insured_truename.equals(paramMap.get("insured_truename").toString())){
                    continue;
                }
            }else if (StringUtils.isNotBlank(paramMap.get("car_number").toString())){
                if (!car_number.equals(paramMap.get("car_number").toString())){
                    continue;
                }
            }
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
    public void audit(Map<String,Object> map) {
        String taskId = map.get("taskId").toString();
        String taskName = map.get("taskName").toString();
        if (taskName.equals("车辆定损核损")){
            vehicleDamageVerifyMapper.audit(map);
        }else if (taskName.equals("人伤定损核损")){
            humanInjuryDamageVerifyMapper.audit(map);
        }else if (taskName.equals("物损定损核损")){
            damageOfGoodsVerifyMapper.audit(map);
        }else if (taskName.equals("盗抢定损核损")){
            robberyDamageVerifyMapper.audit(map);
        }
        Map<String,Object> variables = new HashMap<>();
        variables.put("carAdopt",map.get("is_adopt")); //设置流程变量
        taskService.complete(taskId,variables);
    }
}
