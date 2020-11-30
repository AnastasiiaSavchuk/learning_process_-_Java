package servlet.controller;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Project;
import model.TeamLead;
import model.TeamLeadWorker;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.TeamLeadService;
import service.TeamLeadWorkerService;
import service.WorkerModalService;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;
import service.impl.TeamLeadWorkerServiceImpl;
import service.impl.WorkerModalServiceImpl;
import util.model.WorkerModel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@WebServlet("/teamLead")
public class TeamLeadController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(TeamLeadController.class);
    private TeamLeadWorkerService teamLeadWorkerService;
    private TeamLeadService teamLeadService;
    private ProjectService projectService;
    private WorkerModalService workerModalService;

    public TeamLeadController() {
        teamLeadWorkerService = new TeamLeadWorkerServiceImpl();
        teamLeadService = new TeamLeadServiceImpl();
        projectService = new ProjectServiceImpl();
        workerModalService = new WorkerModalServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int teamLeadId = getProjectIdAndTeamLeadId(req);
        String fullName = req.getParameter("fullName");
        String dateOfBirth = req.getParameter("dateOfBirth");
        Integer salary = Integer.parseInt(req.getParameter("salary"));

        if (Objects.isNull(teamLeadService.readById(teamLeadId))) {
            TeamLead teamLead = new TeamLead(teamLeadId, fullName, dateOfBirth, salary);
            logger.info("POST create /teamLead request : " + teamLead);
            teamLeadService.create(teamLead);

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");
        } else {
            logger.info("TeamLead was already created!");

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("To create");
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("GET request : get workers by teamLead");
        int teamLeadId = getProjectIdAndTeamLeadId(req);

        List<WorkerModel> workerList = workerModalService.getWorkerByTeamlead(teamLeadId);
        logger.info("Workers : " + workerList);

        String json = new Gson().toJson(workerList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("DELETE request : delete product from bucket");

        int workerId = Integer.parseInt(req.getParameter("workerId"));
        int teamLeadId = getProjectIdAndTeamLeadId(req);

        TeamLeadWorker teamLeadWorker = teamLeadWorkerService.readById(teamLeadId, workerId);
        teamLeadWorkerService.delete(teamLeadWorker);
        logger.info("Deleted worker : " + workerId + " , from teamLead : " + teamLeadId);

        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }

    @SneakyThrows
    private int getProjectIdAndTeamLeadId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String projectEmail = session.getAttribute("projectEmail").toString();
        Project project = projectService.readByEmail(projectEmail);
        return project.getId();
    }
}