package com.imooc.oa.dao;

import com.imooc.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jzy
 * 持久层增删改查
 */
@Repository("departmentDao")
public interface DepartmentDao {

    void insert(Department department);
    void update(Department department);
    void delete(String sn);//属性名sn
    Department select(String sn);
    List<Department> selectAll();
}
