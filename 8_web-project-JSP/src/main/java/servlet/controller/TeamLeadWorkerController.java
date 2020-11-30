package servlet.controller;

import dao.TeamLeadWorkerDao;
import dao.impl.TeamLeadWorkerDaoImpl;
import lombok.SneakyThrows;
import model.Project;
import model.TeamLeadWorker;
import org.apache.log4j.Logger;
import service.ProjectService;
import service.TeamLeadService;
import service.TeamLeadWorkerService;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;
import service.impl.TeamLeadWorkerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@WebServlet("/teamLeadWorker")
public class TeamLeadWorkerController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(TeamLeadWorkerController.class);
    private TeamLeadService teamLeadService;
    private TeamLeadWorkerService teamLeadWorkerService;
    private TeamLeadWorkerDao teamLeadWorkerDao;
    private ProjectService projectService;

    public TeamLeadWorkerController() {
        teamLeadService = new TeamLeadServiceImpl();
        teamLeadWorkerService = new TeamLeadWorkerServiceImpl();
        projectService = new ProjectServiceImpl();
        teamLeadWorkerDao = new TeamLeadWorkerDaoImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("POST request : add Worker to TeamLead.");
        Integer workerId = Integer.parseInt(req.getParameter("workerId"));
        int teamLeadId = getProjectIdAndTeamLeadId(req);

        if (Objects.isNull(teamLeadService.readById(teamLeadId))) {
            (req).getRequestDispatcher("teamLeadCreate.jsp").forward(req, resp);
        }
        
        TeamLeadWorker teamLeadWorker = new TeamLeadWorker(teamLeadId, workerId, 1);
        if (isExists(teamLeadWorker)) {
            logger.info("POST request : This Worker was already added to TeamLead.");

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Worker already added");
        } else {
            logger.info("Worker : " + workerId + ", was added to TeamLead : " + teamLeadId);
            teamLeadWorkerService.create(teamLeadWorker);

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");
        }

       /* //case if project want to add 1+ workers
        TeamLeadWorker leadWorker = teamLeadWorkerService.readById(teamLeadId, workerId);
        if (Objects.nonNull(leadWorker)) {
            logger.info("POST request : This product is already added into bucket. Editing product count.");
            leadWorker.setWorkerCount(leadWorker.getWorkerCount() + 1);
            teamLeadWorkerService.updateWorkerCount(leadWorker);
            logger.info("Updated : " + leadWorker);
        } else {
            leadWorker = new TeamLeadWorker(teamLeadId, workerId, 1);
            logger.info("Worker : " + workerId + ", was added to TeamLead : " + teamLeadId);
            teamLeadWorkerService.create(leadWorker);
        }*/
    }

    @SneakyThrows
    private int getProjectIdAndTeamLeadId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String projectEmail = session.getAttribute("projectEmail").toString();
        Project project = projectService.readByEmail(projectEmail);
        return project.getId();
    }

    @SneakyThrows
    private List<TeamLeadWorker> getAll() {
        return teamLeadWorkerDao.readAll();
    }

    @SneakyThrows
    private boolean isExists(TeamLeadWorker teamLeadWorker) {
        boolean flag = false;
        for (TeamLeadWorker entity : getAll()) {
            if (teamLeadWorker.getTeamLeadId() == entity.getTeamLeadId() &&
                    teamLeadWorker.getWorkerId() == entity.getWorkerId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}