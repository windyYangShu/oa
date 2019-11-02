package cn.uestc.oa.dao;


import cn.uestc.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository、@Service、@Controller，它们分别对应存储层Bean，业务层Bean，和展示层Bean
 */
@Repository("employeeDao")
public interface EmployeeDao {
    /**
     * 这两个就没有是用@Param注解，因为满足了不使用注解时的要求
     * 因为没有使用注解只能用#{}方式获得参数而不能使用${}这种方式，使用了注解时两种方式均可，当在实践中一般还是用#{}
     */
    void insert(Employee employee);
    void update(Employee employee);
    void delete(String sn);
    Employee select(String sn);
    List<Employee> selectAll();

    /**在网上参考了别人写的博客，一点都不好,参考白皮的SSM书总结如下：
     * 当传递一个参数时可以直接写
     * 当传递的参数少于5个时一般采用@Param注解形式，在sql语句中要与注解里面起的别名相对应
     * 当传递的参数大于5个时一般采用的是JavaBean形式，如：delete(Param param)
     * 自己把要传递的参数写一个实体类那么在sql语句中可以直接使用该类下的属性
     */
    // 根据部门和职位查询员工信息
    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}
