package com.imooc.oa.controller;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by jzy
 *
 */
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz;
    @RequestMapping("list")
    public String list(Map<String,Object> map){
        map.put("list",departmentBiz.getAll());
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }

    @RequestMapping("/add")
    public String add(Department department){
        departmentBiz.add(department);
        //重定向到list
        return "redirect:list";
    }

    //必须以sn为键传递一个参数进来
    @RequestMapping(value = "/to_update",params = "sn")
    public String toUpdate(String sn,Map<String,Object> map){
        map.put("department",departmentBiz.get(sn));
        return "department_update";
    }


    @RequestMapping("/update")
    public String update(Department department){
        departmentBiz.edit(department);
        //重定向到list
        return "redirect:list";
    }
    //需要传递一个sn用来识别被删除项
    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn){
        departmentBiz.remove(sn);
        return "redirect:list";
    }


}
