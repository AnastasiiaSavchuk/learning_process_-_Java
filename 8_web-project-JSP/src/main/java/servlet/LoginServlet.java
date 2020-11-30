package servlet;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.impl.ProjectServiceImpl;
import util.model.ProjectLogin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class);
    private ProjectService projectService;

    public LoginServlet() {
        projectService = new ProjectServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");

        Project project = projectService.readByEmail(email);

        if (!Objects.isNull(project)) {
            String password = req.getParameter("password");
            if (project.getPassword().equals(password)) {
                logger.info("Project with email : " + email + " was logged in.");
                ProjectLogin projectLogin = new ProjectLogin(email, "cabinet.jsp");

                HttpSession session = req.getSession(true);
                session.setAttribute("projectName", project.getName());
                session.setAttribute("role",project.getRole());
                session.setAttribute("projectEmail", email);

                String json = new Gson().toJson(projectLogin);
                logger.info("JSON login : " + json);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } else {
                logger.info("Wrong password for project with email : " + email);

                resp.setContentType("text");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("Wrong password");
            }
        } else {
            logger.info("Project with email : " + email + " is not registered. Redirection to registration page.");

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Project is NOT registered");
        }
    }
}
