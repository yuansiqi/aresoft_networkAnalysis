package cn.aresoft.manager.controller;

import cn.aresoft.manager.model.SysEmployeeModel;
import cn.aresoft.manager.smo.UserSmo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuans on 2017/9/22.
 */
@Controller
public class LoginController {
    @Autowired
    public UserSmo userSmo;
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> model){
        List<SysEmployeeModel>list =userSmo.queryUser();
        model.put("now", new Date().toString());
        model.put("listSize",list!=null?list.size():0);
        model.put("list",list);
         return "index";
    }
    @RequestMapping(value = {"/index2"}, method = RequestMethod.GET)
    public String index2(Map<String, Object> model){
        List<SysEmployeeModel>list =userSmo.queryUser();
        model.put("now", new Date().toString());
        model.put("listSize",list!=null?list.size():0);
        model.put("list",list);
        return "index2";
    }
    @RequestMapping(value = {"/json"})
    @ResponseBody
    public Map<String,Object> json(){
        List<SysEmployeeModel>list =userSmo.queryUser();
        Map<String,Object> json=new HashMap();
        json.put("dateList",list);
        return json;
    }
}
