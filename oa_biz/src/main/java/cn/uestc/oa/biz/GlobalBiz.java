package cn.uestc.oa.biz;

import cn.uestc.oa.entity.Employee;

public interface GlobalBiz {
    /**
     * 根据姓名和密码创建出员工
     */
    Employee login(String sn, String password);

    void changePassword(Employee employee);
}
