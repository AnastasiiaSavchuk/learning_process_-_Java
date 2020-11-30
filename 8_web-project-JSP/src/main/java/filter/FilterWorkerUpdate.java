package filter;

import filter.service.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/workerUpdate.jsp")
public class FilterWorkerUpdate implements Filter{

    private FilterService filterService;

    public FilterWorkerUpdate() {
        filterService = new FilterService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList("founder"));
    }
}
