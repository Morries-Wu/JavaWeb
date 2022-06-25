package Com.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1、Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2、Filter的init(FilterConfig filterConfig)");
       /*
        1、获取filter的名称 filter-name的内容
        2、获取在web.xml中Filter配置的init-param初始化参数
        3、获取ServletContext对象
        */
        System.out.println("filter-name的值是:" + filterConfig.getFilterName());
        System.out.println("初始化参数username的值是:" + filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getServletContext().getInitParameter("username"));
    }

    /*
      doFilter方法,专门用于拦截请求,可以做权限检查
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3、Filter的doFilter()过滤");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null,说明还没有登录
        if (user == null) {
            servletRequest.getRequestDispatcher("/Filter/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            //让程序继续往下访问用户的目标资源啊
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("4、Filter的destroy()銷毀方法");
    }
}
