package org.java.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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


    public List<Map> getList(){
        List<Map> list=new ArrayList<>();
        Map m=new HashMap();
        m.put("compensate_case_id", 1);
        m.put("schedule_id", 1);
        m.put("insured_truename", 1);
        m.put("car_number", 1);
        m.put("type", 1);

        Map m1=new HashMap();
        m1.put("compensate_case_id", 2);
        m1.put("schedule_id", 2);
        m1.put("insured_truename", 2);
        m1.put("car_number", 3);
        m1.put("type", 3);
        list.add(m);
        list.add(m1);
        return list;
    }



    public List<Map> carMunber(){
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



    public List<Map> md(){
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


}
