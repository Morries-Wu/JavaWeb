package Com.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response01");

        //resp.setStatus(302);//设置响应状态码,表示重定向
        //设置响应头,说明 新的地址在哪里
        //resp.setHeader("Location","http://localhost:8080");
        resp.sendRedirect("http://localhost:8080/Dnamic/response02");
    }
}
