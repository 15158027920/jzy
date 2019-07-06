package com.imooc.oa.controller;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by jzy
 */
@Controller("globalController")
public class GlobalController {

    @Autowired
    private GlobalBiz globalBiz;

    //去登陆
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee = globalBiz.login(sn,password);
        //employee为null，则登录失败
        if(employee==null){
            return "redirect:to_login";
        }else{
            //否则登录成功，保存成功的employee到session里面
            session.setAttribute("employee",employee);
            //跳转到个人信息页面
            return "redirect:self";
        }

    }

    //登陆成功查看个人信息
    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    //退出
    @RequestMapping("/quit")
    public String quit(HttpSession session){
            //否则登录成功，保存成功的employee到session里面
            session.setAttribute("employee",null);
            //跳转到个人信息页面
            return "redirect:to_login";
    }

    //去修改密码
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    //修改密码
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1,@RequestParam String new2){
        Employee employee = (Employee) session.getAttribute("employee");
        //是否等于原始密码，是则允许修改
        if(employee.getPassword().equals(old)){
            //如果两次输入的密码是一致的
            if(new1.equals(new2)){
                //修改密码
                employee.setPassword(new1);
                globalBiz.changePassword(employee);
                return "redirect:self";
           }
        }
        return "redirect:to_change_password";
    }


}
