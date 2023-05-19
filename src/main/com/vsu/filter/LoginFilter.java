package main.com.vsu.filter;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/user/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object logged = httpServletRequest.getSession().getAttribute("logged");

        if (logged != null && (boolean) logged) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect("/login");
    }

    @Override
    public void destroy() {
    }
}
