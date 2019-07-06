package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jzy
 */
@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz{

    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        //调用employeeDao的查询方法
        Employee employee = employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}