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

    @RequestMapping("loadPage")
    private String loadPage(){
        return "nuclearDamage/waitingDamage";
    }

    @RequestMapping("showAll")
    @ResponseBody
    private Map<String,Object> showAll(@RequestParam Map<String,Object> map,HttpSession session){
        map.put("userName",session.getAttribute("userName"));
        return nuclearDamageService.showAll(map);
    }

    @RequestMapping("audit")
    private Map<String,Object> audit(@RequestParam Map<String,Object> map){
        nuclearDamageService.audit(map);
        return null;
    }
}
