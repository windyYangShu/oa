<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!--
request.getContextPath() 应该是得到项目的名字，如/abc.jsp那么就会得到/abc；
如果项目为根目录，则得到一个"",这里index.jsp就是一个根目录，所有页面从该目录下查找
但在JSP文件里,有时通过request.getContextPath()得到的路径却为空。 这是因为context中没有配置path属性，所以你的工程文件就是在根目录下，相当于path="";
相当于你直接在浏览器中输入你的服务器ip就会到你的jsp页面，而不是tomcat的默认页面；所以你通过request.getContextPath()得到的字符串是为空的；它是获得虚目录的；

request.getScheme(); 返回的协议名称,默认是http
request.getServerName(); 返回的是你浏览器中显示的主机名
getServerPort(); 获取服务器端口号
-->