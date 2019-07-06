package com.imooc.oa.biz;

import com.imooc.oa.entity.Employee;

/**
 * Created by jzy
 */
public interface GlobalBiz {
    Employee login(String sn,String password);
    void changePassword(Employee employee);


}
