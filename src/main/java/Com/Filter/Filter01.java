package Com.Filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter01 前置代码");
        System.out.println("Filter01线程" + Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter01 后置代码");
    }

    @Override
    public void destroy() {

    }
}
