package filter.service;

import lombok.SneakyThrows;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FilterService {

    @SneakyThrows
    public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain,
                                   List<String> allowedRole) {
        try {
            HttpSession session = ((HttpServletRequest) request).getSession();
            String role = session.getAttribute("role").toString();

            if (!role.isEmpty() && allowedRole.contains(role)) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            ((HttpServletRequest) request).getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
