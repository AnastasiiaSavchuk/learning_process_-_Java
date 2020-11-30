package servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LogOutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("GET /logout request.");
        HttpSession session = req.getSession();
        if (Objects.isNull(session)) session.invalidate();
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("index.jsp");
    }
}