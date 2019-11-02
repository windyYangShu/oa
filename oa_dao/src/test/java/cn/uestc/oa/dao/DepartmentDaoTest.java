package cn.uestc.oa.dao;

import cn.uestc.oa.BaseTest;
import cn.uestc.oa.entity.Department;
import cn.uestc.oa.entity.Employee;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yang
 * @title: DepartmentDaoTest
 * @projectName oa
 * @description: dao层的单元测试
 * @date 2019/11/1/9:33
 */

// 这个注解是用来控制测试的方法的执行顺序的，测试方法的命名：test_字母顺序_原方法名按照上面的方法命名规范就可以根据字母顺序来控制每一个方法执行的前后顺序了
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest extends BaseTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    // 测试查询所用部门功能
    public void testAselectAll() throws Exception{
        // 进行部门查询
        List<Department> departmentList = departmentDao.selectAll();
        // 数据库中有三个部门信息，确认查到的部门总数是否与数据库中数目相对应，当数目不相等时就会报错提示
        assertEquals(3,departmentList.size());
    }

    @Test
    // 测试插入方法
    public void testBinsert() throws Exception{
        Department department = new Department();
        department.setSn("10009");
        department.setName("测试");
        //利用返回值来判断是否执行成功了
        int effectedNum = departmentDao.insert(department);
        assertEquals(1,effectedNum);
    }

    @Test
    // 测试更新方法
    public void testCupdate() throws Exception{
        Department department = new Department();
        department.setSn("10009");
        department.setName("测试更新");
        //利用返回值来判断是否执行成功了
        int effectedNum = departmentDao.update(department);
        assertEquals(1,effectedNum);
    }

    @Test
    // 测试删除方法
    public void testDdelate() throws Exception{
        Department department = new Department();
        //利用返回值来判断是否执行成功了
        int effectedNum = departmentDao.delete("10009");
        assertEquals(1,effectedNum);
    }
}
