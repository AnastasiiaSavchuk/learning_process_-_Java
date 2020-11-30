package service;

import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Project;
import model.TeamLead;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.impl.ProjectServiceImpl;
import service.impl.TeamLeadServiceImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TeamLeadServiceImplTest {

    private static TeamLeadService teamLeadService;
    private static ProjectService projectService;

    @BeforeAll
    static void init() {
        teamLeadService = new TeamLeadServiceImpl();
        projectService = new ProjectServiceImpl();
    }

    @Test
    @DisplayName("Read all projects")
    public void readAllTest() throws SQLException {
        List<TeamLead> teamLeadList = teamLeadService.readAll();
        Assertions.assertTrue(teamLeadList.size() >= 1);
    }

    @Test
    @DisplayName("Create, update and delete new project")
    public void createAndUpdateAndDeleteTest() throws SQLException, AlreadyExistException, NotFoundException {
        int createId = 111;

        Project testProject = new Project(createId, "Test_CREATE_project", 0, "test_CREATE@yahho.com", "1212tcp");
        projectService.create(testProject);
        Project actual = projectService.readById(createId);
        Assertions.assertEquals(testProject, actual);

        TeamLead testTeamLead = new TeamLead(createId, "Test_CREATE_team_lead_name", new Timestamp(1969 - 11 - 22), 0);
        teamLeadService.create(testTeamLead);
        TeamLead actualTeamLead = teamLeadService.readById(createId);
        Assertions.assertEquals(testTeamLead.getId(), actualTeamLead.getId());
        Assertions.assertEquals(testTeamLead.getDateOfBirth().getDate(), actualTeamLead.getDateOfBirth().getDate());

        TeamLead current = new TeamLead(createId, "Test_UPDATE_team_lead_name", new Timestamp(1989 - 10 - 02), 0);
        teamLeadService.update(createId, current);
        Assertions.assertEquals(current.getDateOfBirth().getDate(), teamLeadService.readById(createId).getDateOfBirth().getDate());

        teamLeadService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> teamLeadService.readById(createId));

        projectService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> projectService.readById(createId));
    }
}