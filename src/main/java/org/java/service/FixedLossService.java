package org.java.service;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.dao.FixedLossMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/2/14 11:32
 * @Description:
 */
@Service
public class FixedLossService {

    @Autowired(required = false)
    private FixedLossMapper fixedLossMapper;

    @Autowired(required =false)
    private TaskService taskService;

    public List<Map> getList(Map map){
//        TaskQuery taskQuery=taskService.createTaskQuery();
//        taskQuery.taskAssignee(map.get("user").toString());
//        List<Task> taskList=taskQuery.list();
//        List<Map> lists=new ArrayList<>();
//        for (Task t:
//             taskList) {
//            String processInstanceId=t.getProcessInstanceId();
//            map.put("instance_id",processInstanceId);
//            Map m=fixedLossMapper.scheduleFindBy(map);
//            m.put("taskId",t.getId());
//            lists.add(m);
//        }
        List<Map> list=new ArrayList<>();
        Map m=new HashMap();
        m.put("compensate_case_id", 1);
        m.put("schedule_id", 2);
        Map m4=new HashMap();
        m4.put("compensate_case_id", 1);
        m4.put("schedule_id", 1);
        Map m1=new HashMap();
        m1.put("compensate_case_id", 1);
        m1.put("schedule_id", 3);
        Map m2=new HashMap();
        m2.put("compensate_case_id", 1);
        m2.put("schedule_id", 4);
        Map m3=new HashMap();
        m3.put("compensate_case_id", 1);
        m3.put("schedule_id", 5);
        list.add(m);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        return list;
    }


    /**
     * 人伤定损根据车牌号查询信息
     * @param id
     * @return
     */
    public List<Map> carMunber(String id){

        Map maps=new HashMap();
        maps.put("car_number",id);
//        fixedLossMapper.humanFind(maps);
        List<Map> list=new ArrayList<>();
        Map m=new HashMap();
        m.put("costName", 1);
        m.put("nameOfRisk", 1);
        m.put("describe", 1);
        m.put("compensationFormula", 1);

        m.put("amountOfLossReported", 1);
        m.put("excludedAmount", 1);
        m.put("amountOfLossAssessed", 1);

        Map m1=new HashMap();
        m1.put("costName", 2);
        m1.put("nameOfRisk", 2);
        m1.put("describe", 2);
        m1.put("compensationFormula", 3);
        m1.put("amountOfLossReported", 3);
        m1.put("excludedAmount", 3);
        m1.put("amountOfLossAssessed", 3);
        list.add(m);
        list.add(m1);
        return list;
    }


    /**
     * 物损查询
     * @return
     */
    public List<Map> md(@RequestParam Map map){

//        List<Map> lists=fixedLossMapper.damage(map);
        List<Map> list=new ArrayList<>();
        Map m=new HashMap();
        m.put("fee_name", 1);
        m.put("loss_description", 1);
        m.put("report_loss_price", 1);
        m.put("eliminate_price", 1);
        m.put("estimate_price", 1);

        Map m1=new HashMap();
        m1.put("fee_name", 2);
        m1.put("loss_description", 2);
        m1.put("report_loss_price", 2);
        m1.put("eliminate_price", 3);
        m1.put("estimate_price", 3);
        list.add(m);
        list.add(m1);
        return list;
    }

    /**
     * 根据调度编号查询对应车损数据
     */
    public Map InvestigationFindBy(Map m){
        return fixedLossMapper.InvestigationFindBy(m);
    }

    /**
     * 往事故现场查勘照片表插入数据
     */
    public void investigatioImgAdd(Map m){
        fixedLossMapper.investigatioImgAdd(m);
    }

    /**
     * 往现场查勘表插入数据
     * @param m
     */
    public void investigationAdd(Map m){
        fixedLossMapper.investigationAdd(m);
    }

    /**
     * 根据调度编号查询盗抢信息表
     */
    public Map robberyDamageFind(Map m){
        return fixedLossMapper.robberyDamageFind(m);
    }

    public void robberyDamageAdd(Map m){
        fixedLossMapper.investigatioImgAdd(m);
    }

}
