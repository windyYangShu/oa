package cn.uestc.oa.biz;

import cn.uestc.oa.BaseTest;
import cn.uestc.oa.entity.Department;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yang
 * @title: DepartmentBizTest
 * @projectName oa
 * @description: TODO
 * @date 2019/11/1/11:27
 */

// 这个注解是用来控制测试的方法的执行顺序的，测试方法的命名：test_字母顺序_原方法名按照上面的方法命名规范就可以根据字母顺序来控制每一个方法执行的前后顺序了
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentBizTest extends BaseTest {
    @Autowired
    private DepartmentBiz departmentBiz;

    @Test
    // 测试查询所用部门功能
    public void testAgetAll() throws Exception{
        // 进行部门查询
        List<Department> departmentList = departmentBiz.getAll();
        // 数据库中有三个部门信息，确认查到的部门总数是否与数据库中数目相对应，当数目不相等时就会报错提示
        assertEquals(3,departmentList.size());
    }
}
