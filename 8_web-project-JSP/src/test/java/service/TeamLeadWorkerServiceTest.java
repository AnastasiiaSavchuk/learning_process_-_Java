package service;

import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Project;
import model.TeamLead;
import model.TeamLeadWorker;
import model.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;
import service.impl.TeamLeadWorkerServiceImpl;
import service.impl.WorkerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class TeamLeadWorkerServiceTest {

    private static TeamLeadWorkerService teamLeadWorkerService;
    private static ProjectService projectService;
    private static TeamLeadService teamLeadService;
    private static WorkerService workerService;

    @BeforeAll
    static void init() {
        teamLeadWorkerService = new TeamLeadWorkerServiceImpl();
        projectService = new ProjectServiceImpl();
        teamLeadService = new TeamLeadServiceImpl();
        workerService = new WorkerServiceImpl();
    }

    @Test
    @DisplayName("Read all team_lead + worker")
    public void redAllTest() throws SQLException {
        List<TeamLeadWorker> teamLeadWorkerList = teamLeadWorkerService.readAll();
        Assertions.assertTrue(teamLeadWorkerList.size() >= 1);
    }

    @Test
    @DisplayName("Create and delete new team_lead + worker")
    public void createAndDeleteTest() throws SQLException, AlreadyExistException, NotFoundException {
        int createId = 333;

        Project testProject = new Project(createId, "client", "Test_CREATE_project", 0, "test_CREATE@yahho.com", "12345678");
        projectService.create(testProject);
        Project actual = projectService.readById(createId);
        Assertions.assertEquals(testProject, actual);

        TeamLead testTeamLead = new TeamLead(createId, "Test_CREATE_team_lead_name", "1969-11-22", 0);
        teamLeadService.create(testTeamLead);
        TeamLead actualTeamLead = teamLeadService.readById(createId);
        Assertions.assertEquals(testTeamLead.getId(), actualTeamLead.getId());
        Assertions.assertEquals(testTeamLead, actualTeamLead);

        Worker testWorker = new Worker(createId, "Test_CREATE_worker", "Test", 0);
        workerService.create(testWorker);
        Worker actualWorker = workerService.readById(createId);
        Assertions.assertEquals(testWorker, actualWorker);

        TeamLeadWorker testTeamLeadWorker = new TeamLeadWorker(testTeamLead.getId(), testWorker.getId(), 1);
        teamLeadWorkerService.create(testTeamLeadWorker);
        TeamLeadWorker actualTeamLeadWorker = teamLeadWorkerService.readById(testTeamLead.getId(), testWorker.getId());
        Assertions.assertEquals(testTeamLeadWorker, actualTeamLeadWorker);

        teamLeadWorkerService.delete(testTeamLeadWorker);
        Assertions.assertThrows(NotFoundException.class, () -> teamLeadWorkerService.readById(testTeamLead.getId(), testWorker.getId()));

        workerService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> workerService.readById(createId));

        teamLeadService.delete(createId);
        Assertions.assertNull(teamLeadService.readById(createId));

        projectService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> projectService.readById(createId));
    }
}
