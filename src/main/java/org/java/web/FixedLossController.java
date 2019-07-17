package org.java.web;

import org.java.service.FixedLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class FixedLossController {

    @Autowired
    private FixedLossService productService;




    /**
     * 返回查勘待定损
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map getList(){

        Map map=new HashMap();
        map.put("code",0);
        map.put("count",1000);
        map.put("msg","");
        map.put("data",productService.getList());

        return map;
    }

    /**
     * 待查勘
     * @return
     */
    @RequestMapping("init")
    public String init(){
        return "FixedLoss/Insurance";
    }


    /**
     * 车损
     * @return
     */
    @RequestMapping("car")
    public String car(){
        return "FixedLoss/VehicleDamage";
    }

    /**
     * 人伤查勘定损
     * @return
     */
    @RequestMapping("human")
    public String human(){

        return "FixedLoss/humanInjury";
    }


    /**
     * 盗抢查勘定损页面
     * @return
     */
    @RequestMapping("robbery")
    public String robberyAndSurvey(){

        return "FixedLoss/robberyAndSurvey";
    }



    /**
     * 根据车牌差看详细信息
     * @return
     */
    @RequestMapping("humanDetails")
    @ResponseBody
    public Map humanDetails(){
        System.out.println("1111111111111111111111111111111111111111111111111111");
        Map map=new HashMap();
        map.put("code",0);
        map.put("count",1000);
        map.put("msg","");
        map.put("data",productService.carMunber());

        return map;
    }


    /**
     * 定损页面(车损)
     * @return
     */
    @RequestMapping("sue")
    public String sue(){
        return "FixedLoss/sue";
    }


}
