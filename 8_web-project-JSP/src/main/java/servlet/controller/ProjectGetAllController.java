package servlet.controller;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.impl.ProjectServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/getProject")
public class ProjectGetAllController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ProjectGetAllController.class);
    private ProjectService projectService;

    public ProjectGetAllController() {
        projectService = new ProjectServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Project> projectList = projectService.readAll();
        String json = new Gson().toJson(projectList);

        logger.info("GET /getProject request.");
        logger.info("Projects : " + json);


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
