package com.imooc.oa.biz;

import com.imooc.oa.entity.Department;

import java.util.List;

/**
 * Created by jzy
 * 对部门信息进行增删改查
 * 业务层
 */
public interface DepartmentBiz {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();

}
