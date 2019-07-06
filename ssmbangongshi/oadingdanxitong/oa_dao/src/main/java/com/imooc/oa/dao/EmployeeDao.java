package com.imooc.oa.dao;

import com.imooc.oa.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jzy
 * 持久层增删改查
 */
@Repository("employeeDao")
public interface EmployeeDao {
    void insert(Employee employee);
    void update(Employee employee);
    void delete(String sn);//属性名sn
    Employee select(String sn);
    List<Employee> selectAll();
}
