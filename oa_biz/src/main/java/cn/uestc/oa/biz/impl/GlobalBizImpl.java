package cn.uestc.oa.biz.impl;

import cn.uestc.oa.biz.GlobalBiz;
import cn.uestc.oa.dao.EmployeeDao;
import cn.uestc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    //这里的报错并不会影响程序的运行，idea自身的问题，直接忽略即可
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 根据传入的账号和密码创建员工实体
     * 如果和数据库中的相对应则返回相应的员工实体，如果账号和密码不对应则返回null
     */
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return  employee;
        }
        return null;
    }

    /**
     * 更新密码
     */
    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
