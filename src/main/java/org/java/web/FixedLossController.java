package org.java.web;

import javafx.concurrent.Task;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.assertj.core.internal.Bytes;
import org.java.service.FixedLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class FixedLossController {

    @Autowired
    private FixedLossService fixedLossService;

    @Autowired(required = false)
    private ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();


    @RequestMapping("index")
    public String index(){
        return "index";
    }


    /**
     * 返回查勘待定损
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map getList(@RequestParam Map m){

        System.out.println(m);

        Map map=new HashMap();
        map.put("code",0);
        map.put("count",1000);
        map.put("msg","");
        map.put("data",fixedLossService.getList(m));

        return map;
    }


    @RequestMapping("/findAlls")
    @ResponseBody
    public String findAlls(){
        return "FixedLoss/survey";
    }


    /**
     * 待查勘
     * @return
     */
    @RequestMapping("init")
    public String init(HttpSession session){
        System.out.println(session.getAttribute("emp"));
        return "FixedLoss/Insurance";
    }


    /**
     * 车损
     * @return
     */
    @RequestMapping("car")
    public String car(@RequestParam Map m,Model model){

//        Map map=fixedLossService.InvestigationFindBy(m);
//        model.addAttribute("m", map);
        System.out.println("asdasdasdasd");
        return "FixedLoss/VehicleDamage";
    }

    /**
     * 人伤查勘定损
     * @return
     */
    @RequestMapping("human")
    public String human(Model m){

        m.addAttribute("name","1234567");
        m.addAttribute("fixed_loss_remarks","1234567");
        return "FixedLoss/humanInjury";
    }


    /**
     * 查勘车损文件上传
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String investigationId=request.getParameter("investigation_id");//获取对应的查勘编号
        String fileName=file.getOriginalFilename();//获取文件名

        System.out.println(investigationId);
        System.out.println(fileName);

        byte[] bytes=file.getBytes();


        Map m=new HashMap();
        m.put("investigationId",investigationId);
        m.put("bytes",bytes);
        m.put("fileName",fileName);
        fixedLossService.investigatioImgAdd(m);



        Map map = new HashMap<String,Object>();
        map.put("msg","ok");
        map.put("code",200);


        return map;
    }

    /**
     * 往现场勘查定损表中插入数据
     */
    @RequestMapping("investigationAdd")
    @ResponseBody
    public void investigationAdd(@RequestParam Map m){
        fixedLossService.investigationAdd(m);
    }


    /**
     * 盗抢查勘定损页面
     * @return
     */
    @RequestMapping("robbery")
    public String robberyAndSurvey(@RequestParam Map m,Model model){

//        Map map=fixedLossService.robberyDamageFind(m);
//        model.addAttribute("m", map);

        return "FixedLoss/robberyAndSurvey";
    }



    /**
     * 根据车牌差看详细信息
     * @return
     */
    @RequestMapping("humanDetails")
    @ResponseBody
    public Map humanDetails(String id){
        Map map=new HashMap();
        map.put("code",0);
        map.put("count",1000);
        map.put("msg","");
        map.put("data",fixedLossService.carMunber(id));
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


    /**
     * 物损查勘定损页面
     * @return
     */
    @RequestMapping("MaterialDamage")
    public String MaterialDamage(){
        return "FixedLoss/MaterialDamage";
    }


    @RequestMapping("md")
    @ResponseBody
    public Map md(@RequestParam Map m){
        Map map=new HashMap();
        map.put("code",0);
        map.put("count",1000);
        map.put("msg","");
        map.put("data",fixedLossService.md(m));

        return map;
    }


    /**
     * 流程提交
     */
    public void completeTask(){
        TaskService service=engine.getTaskService();
        String taskId="";
        service.complete(taskId);
    }

    /**
     *车损数据保存
     */
    @RequestMapping("carAdd")
    @ResponseBody
    public String carAdd(@RequestParam Map m){
        System.out.println(m);
        
        TaskService service=engine.getTaskService();
        String taskId=m.get("instance_id").toString();

        String processInstanceId = service.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        m.put("processInstanceId",processInstanceId);
        fixedLossService.investigationAdd(m);
        service.complete(taskId);
        return "";
    }

    @RequestMapping("humanAdd")
    @ResponseBody
    public String humanAdd(@RequestParam Map m){
        System.out.println(m);
        return "";
    }


    @RequestMapping("mdAdd")
    @ResponseBody
    public String mdAdd(@RequestParam Map m){
        System.out.println(m);
        return "";
    }

    @RequestMapping("robberyAdd")
    @ResponseBody
    public String robbery(@RequestParam Map m){
        TaskService service=engine.getTaskService();
        String taskId=m.get("instance_id").toString();
        String processInstanceId=service.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        m.put("processInstanceId",processInstanceId);
        fixedLossService.robberyDamageAdd(m);
        service.complete(taskId);
        return "";

    }



}
