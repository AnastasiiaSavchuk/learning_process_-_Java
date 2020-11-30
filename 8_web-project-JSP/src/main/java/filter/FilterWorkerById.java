package filter;


import filter.service.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/workerById.jsp")
public class FilterWorkerById implements Filter {

    private FilterService filterService;

    public FilterWorkerById() {
        filterService = new FilterService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation(servletRequest, servletResponse, filterChain, Arrays.asList("client", "founder"));
    }
}
