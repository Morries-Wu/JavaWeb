package Com.Context;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取web.xml中配置的上下文参数context-param,getServletContext();
        ServletContext context =getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值是:"+username);
        System.out.println("context-param参数password的值是:"+ ((ServletContext) context).getInitParameter("password"));
        //2、获取当前的工程路径,格式:/工程路径
        System.out.println("当前工程路径:"+context.getContextPath());
        //3、获取工程部署后在服务器硬盘上的绝对路径]
        //斜杠被服务器解析地址为:http://ip:port/工程名
        System.out.println("工程部署的路径是:"+context.getRealPath("/"));
        //4、像Map一样存储数据
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
