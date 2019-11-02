package cn.uestc.oa.controller;

import cn.uestc.oa.biz.GlobalBiz;
import cn.uestc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller("globalController")

public class GloablController {
    @Autowired
    private GlobalBiz globalBiz;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    /**
     * @RequestMapping 可以用来注释一个类或方法，指示spring中用哪一个类或方法处理请求动作
     * @RequestParam 将指定的请求参数赋值给方法中的形参，这里的sn，password要和login.jsp中的相应的id名称一致
     */
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        // 根据账号和密码，创建出员工对象
        Employee employee = globalBiz.login(sn,password);
        if (employee == null) {
            return "redirect:to_login";
        }
        // 将该员工对象设置到session会话中
        session.setAttribute("employee",employee);
        return "redirect:self";
    }

    /**
     * 展示个人信息
     */
    @RequestMapping("/self")
    public String self(){
        return  "self";
    }

    /**
     * 退出
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 , @RequestParam String new2){
        // 从会话中拿到员工对象
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee.getPassword().equals(old)){
            if(new1.equals(new2)){
                employee.setPassword(new1);
                globalBiz.changePassword(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }

}
