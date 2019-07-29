package org.java.web;

import org.java.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class NuclearDamageController {
    @Autowired
    private NuclearDamageService nuclearDamageService;
    @Autowired
    private DamageOfGoodsService damageOfGoodsService;
    @Autowired
    private HumanInjuryDamageService humanInjuryDamageService;
    @Autowired
    private RobberyDamageService robberyDamageService;
    @Autowired
    private VehicleDamageService vehicleDamageService;
    @Autowired
    private ReplaceProjectService replaceProjectService;
    @Autowired
    private RepairProjectService repairProjectService;

    @RequestMapping("/loadPage")
    private String loadPage(){
        System.out.println("123");
        return "/nuclearDamage/waitingDamage";
    }

    @RequestMapping("showAll")
    @ResponseBody
    private Map<String,Object> showAll(@RequestParam Map<String,Object> map,HttpSession session){
        Map<String,Object> emp = (Map<String, Object>) session.getAttribute("emp");
        map.put("userName",emp.get("emp_username"));
        return nuclearDamageService.showAll(map);
    }

    @RequestMapping("cheSunAudit")
    private Map<String,Object> cheSunAudit(@RequestParam Map<String,Object> map){
        nuclearDamageService.cheSunAudit(map);
        return null;
    }
    @RequestMapping("daoQaingAudit")
    private Map<String,Object> daoQaingAudit(@RequestParam Map<String,Object> map){
        System.out.println("进入盗抢审核");
        nuclearDamageService.daoQaingAudit(map);
        return null;
    }

    @RequestMapping("showCheLiang")
    @ResponseBody
    private Map<String,Object> showCheLiang(String vehilce_damage_id){
        return vehicleDamageService.findById(vehilce_damage_id);
    }

    @RequestMapping("showRenShang")
    @ResponseBody
    private Map<String,Object> showRenShang(String human_injury_damage_id){
        return humanInjuryDamageService.findById(human_injury_damage_id);
    }

    @RequestMapping("showDaoQiang")
    @ResponseBody
    private Map<String,Object> showDaoQiang(String robbery_damage_id){
        return robberyDamageService.findById(robbery_damage_id);
    }

    @RequestMapping("showWuSun")
    @ResponseBody
    private Map<String,Object> showWuSun(String damage_of_goods_id){
        return damageOfGoodsService.findById(damage_of_goods_id);
    }

    @RequestMapping("showRepairProject")
    @ResponseBody
    private Map<String,Object> showRepairProject(String vehilce_damage_id){
        return repairProjectService.findByVehilceDamageId(vehilce_damage_id);
    }

    @RequestMapping("showReplaceProject")
    @ResponseBody
    private Map<String,Object> showReplaceProject(String vehilce_damage_id){
        return replaceProjectService.findByVehilceDamageId(vehilce_damage_id);
    }
}
