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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private ProjectService projectService;
    private static final Logger logger = Logger.getLogger(RegistrationServlet.class);

    public RegistrationServlet() {
        projectService = new ProjectServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        if (projectService.readByEmail(email) == null) {
            logger.info("Registration for new project.");
            String projectName = req.getParameter("name");
            int budget = Integer.parseInt(req.getParameter("budget"));
            String password = req.getParameter("password");
            if (!email.isEmpty() && !projectName.isEmpty() && budget != 0 && !password.isEmpty()) {
                Project project = new Project(projectName, budget, email, password);
                projectService.create(project);
                logger.info("Project was registered : " + project);
                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            }
        } else {
            logger.info("Project with email : " + email + " already registered! Redirection to login page");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
