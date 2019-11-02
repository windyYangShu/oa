package cn.uestc.oa.dao;


import cn.uestc.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 详细注释参考EmployeeDao
 */
@Repository("departmentDao")
public interface DepartmentDao {
    // 没有MyBatis会返回受影响的条数，利用这个特性可以定义返回为int型，方便进行单元测试
    int insert(Department department);
    int update(Department department);
    int delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
