package cn.uestc.oa.biz.impl;

import cn.uestc.oa.biz.EmployeeBiz;
import cn.uestc.oa.dao.EmployeeDao;
import cn.uestc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {

    // 自动装载注解
    @Autowired
    //这里的报错并不会影响程序的运行，idea自身的问题，直接忽略即可
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        // 因为密码不能为空，因此在插入员工前要先设置密码的
        employee.setPassword("000000");
        // 插入员工
        employeeDao.insert(employee);
    }

    // 更新员工信息
    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    // 根据编号删除员工
    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    // 根据编号得到员工信息
    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    // 获得所有员工信息
    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
