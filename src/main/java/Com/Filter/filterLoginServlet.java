package Com.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class filterLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("Morries_Wu".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功");
            req.getRequestDispatcher("/Filter/admin/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/Filter/login.jsp").forward(req, resp);
        }

    }
}
