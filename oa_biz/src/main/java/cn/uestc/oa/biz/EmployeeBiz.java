package cn.uestc.oa.biz;


import cn.uestc.oa.entity.Employee;

import java.util.List;

/**
 * 当整个项目逻辑简单时，业务层基本上就是简单dao层的重复
 */

public interface EmployeeBiz {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
