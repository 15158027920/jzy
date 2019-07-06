package com.imooc.oa.biz;


import com.imooc.oa.entity.Employee;

import java.util.List;

/**
 * Created by jzy
 * 对部门信息进行增删改查
 * 业务层
 */
public interface EmployeeBiz {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();

}
