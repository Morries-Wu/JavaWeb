package Com.Cookie;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");
        //2、通知客户端保存Cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.getWriter().write("Cookie创建成功");
    }


    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookies[] = request.getCookies();
        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        if (iWantCookie != null) {
            response.getWriter().write("找到了需要的Cookie");
        }
    }


    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*方案一:
        1、先创建一个需要修改同名的Cookie对象
        2、在构造器,同时赋予新的Cookie值
        3、调用response.addCookie(Cookie);
        Cookie cookie = new Cookie("key1", "newvalue1");
        resp.addCookie(cookie);
        resp.getWriter().write("key1的Cookie已经修改好");

        方案二
        1、先查找到需要修改的Cookie对象
        2、调用setValue()方法赋于新的Cookie值
        3、调用response.addCookie()通知客户端保存修改
        */
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            cookie.setValue("newvalue2");
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key2的Cookie已经修改好");

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        /*
        正数,表示在指定的秒数后过期
        负数,表示浏览器一关,Cookie就会被删除(默认值是-1)
        零,表示马上删除Cookie
        */
        //设置存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        先找到你要删除的Cookie对象
        调用setMaxAge(0);
        调用response.addCookie(cookie);
        */
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key1的Cookie已經被刪除");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        //设置Cookie一小时之后被删除,无效
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");

    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //req.getContextPath() 得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");//表示/工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的Cookie");
    }


}
