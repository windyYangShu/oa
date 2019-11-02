package cn.uestc.oa.biz.impl;

import cn.uestc.oa.biz.DepartmentBiz;
import cn.uestc.oa.dao.DepartmentDao;
import cn.uestc.oa.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
    //为了测试logback工作情况
    Logger logger = LoggerFactory.getLogger(DepartmentBizImpl.class);

    //这里的报错并不会影响程序的运行，idea自身的问题，直接忽略即可
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        //在日志系统中自定义一些信息
        logger.info("===start===");
        return departmentDao.selectAll();
    }
}
