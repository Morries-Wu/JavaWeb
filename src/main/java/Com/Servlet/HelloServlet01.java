package Com.Servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet01 extends HttpServlet {

    public HelloServlet01() {
        System.out.println("1、构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、init初始化方法");
        // 1、可以获取Servlet程序的别名Servlet-name的值
        System.out.println("HelloServlet程序的别名:" + servletConfig.getServletName());
        // 2、获取初始化参数init-param
        System.out.println("初始化参数username的值是:" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是:" + servletConfig.getInitParameter("url"));
        // 3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service方法是专门用来处理请求和响应
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、Hello servlet 被访问了");
        //类型转换(因为它有getmethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet() {
        System.out.println("GET请求");
    }

    public void doPost() {
        System.out.println("POST请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、destroy销毁方法");
    }
}