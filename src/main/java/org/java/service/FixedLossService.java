package org.java.service;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.dao.FixedLossMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private HttpSession session;

    /**
     * 现场查勘
     * @param map
     * @return
     */
    public List<Map> getList(Map map){
        Map userName=(Map) session.getAttribute("emp");
        System.out.println(userName.get("emp_username"));
        TaskQuery taskQuery=taskService.createTaskQuery();
        taskQuery.taskAssignee(userName.get("emp_username").toString());
        List<Task> taskList=taskQuery.list();
        List<Map> list=new ArrayList<>();
        for (Task t:
                taskList) {
            String processInstanceId=t.getProcessInstanceId();
            map.put("instance_id",processInstanceId);
            Map m=fixedLossMapper.scheduleFindBy(map);
            m.put("taskId",t.getId());
            list.add(m);
        }
        return list;
    }

    /**
     * 车损定损查询
     */
    public List<Map> carFixed(Map map){
        Map userName=(Map) session.getAttribute("emp");
        System.out.println(userName.get("emp_username"));
        TaskQuery taskQuery=taskService.createTaskQuery();
        taskQuery.taskAssignee(userName.get("emp_username").toString());
        List<Task> taskList=taskQuery.list();
        List<Map> lists=new ArrayList<>();
        for (Task t:
             taskList) {
            System.out.println(map);
            String processInstanceId=t.getProcessInstanceId();
            map.put("instance_id",processInstanceId);
            Map m=fixedLossMapper.carFixedFind(map);
            m.put("taskId",t.getId());
            lists.add(m);
        }
        return lists;
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
        System.out.println(m);
        fixedLossMapper.investigationAdd(m);
    }

    /**
     * 根据调度编号查询盗抢信息表
     */
    public Map robberyDamageFind(Map m){
        return fixedLossMapper.robberyDamageFind(m);
    }

    /**
     * 盗抢图片插入
     * @param m
     */
    public void robberyDamageAdd(Map m){
        fixedLossMapper.investigatioImgAdd(m);
    }

}
