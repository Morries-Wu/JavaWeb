package Com.Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("Morries_Wu".equals(username) && "123456".equals(password)) {
            //登录成功,把账号信息保存为Cookie
            Cookie cookie = new Cookie("username", username);
            //当前Cookie一周内有效
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            System.out.println("登录成功");
        } else {
            //登录失败
            System.out.println("登录失败");
        }

    }

}
