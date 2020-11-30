package servlet;

import lombok.SneakyThrows;
import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.impl.ProjectServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(RegistrationServlet.class);
    private ProjectService projectService;

    public RegistrationServlet() {
        projectService = new ProjectServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        if (Objects.isNull(projectService.readByEmail(email))) {
            logger.info("Registration for new project");
            String name = req.getParameter("name");
            Integer budget = Integer.parseInt(req.getParameter("budget"));
            String password = req.getParameter("password");
            if (!email.isEmpty() && !name.isEmpty() && budget != 0 && !password.isEmpty()) {
                Project project = new Project("client", name, budget, email, password);
                projectService.create(project);
                logger.info("Project was registered : " + project);

                HttpSession session = req.getSession(true);
                session.setAttribute("projectName", name);
                session.setAttribute("projectEmail", email);
            }

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");
        } else {
            logger.info("Project with email : " + email + " already registered! Redirection to login page");

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("To login");
        }
    }
}