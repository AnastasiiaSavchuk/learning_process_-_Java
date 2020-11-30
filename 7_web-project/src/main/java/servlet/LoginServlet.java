package servlet;

import lombok.SneakyThrows;
import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.impl.ProjectServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ProjectService projectService;
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    public LoginServlet() {
        projectService = new ProjectServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Project project = projectService.readByEmail(email);
        if (project != null) {
            if (project.getPassword().equals(password)) {
                logger.info("Project with email : " + email + " was logged in.");
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                logger.info("Wrong password for project with email : " + email);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            logger.info("Project with email : " + email + " is not registered. Redirection to registration page.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
