package filter;

import filter.service.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/workerCreate.jsp")
public class FilterWorkerCreate implements Filter{

    private FilterService filterService;

    public FilterWorkerCreate() {
        filterService = new FilterService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList("founder"));
    }
}
