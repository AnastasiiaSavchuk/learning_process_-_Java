package service;

import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.impl.ProjectServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ProjectServiceImplTest {

    private static ProjectService projectService;

    @BeforeAll
    static void init() {
        projectService = new ProjectServiceImpl();
    }

    @Test
    @DisplayName("Read all projects")
    public void readAllTest() throws SQLException {
        List<Project> projectList = projectService.readAll();
        Assertions.assertTrue(projectList.size() >= 1);
    }

    @Test
    @DisplayName("Read project by email")
    public void readByEmail() throws SQLException, NotFoundException {
        String testEmail = "test@gmail.com";
        Project expected = new Project( 0,"client","Test project", 0, testEmail, "11111111");
        Project actual = projectService.readByEmail(testEmail);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Create, update and delete new project")
    public void createAndUpdateAndDeleteTest() throws SQLException, AlreadyExistException, NotFoundException {
        int createId = 111;

        Project testProject = new Project(createId, "client", "Test_CREATE_project", 0000, "test_CREATE@yahho.com", "1212tcp");
        projectService.create(testProject);
        Project actual = projectService.readById(createId);
        Assertions.assertEquals(testProject, actual);

        Project current = new Project(createId, "client", "Test_UPDATE_project", 0000, "test_UPDATE@yahho.com", "1212tcp");
        projectService.update(createId, current);
        Assertions.assertEquals(current, projectService.readById(createId));

        projectService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> projectService.readById(createId));
    }
}