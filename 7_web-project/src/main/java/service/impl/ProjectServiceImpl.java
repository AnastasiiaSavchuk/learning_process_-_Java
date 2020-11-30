package service.impl;

import dao.ProjectDao;
import dao.impl.ProjectDaoImpl;
import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;

import java.sql.SQLException;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;
    private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

    public ProjectServiceImpl() {
        projectDao = new ProjectDaoImpl();
    }

    @Override
    public List<Project> readAll() throws SQLException {
        logger.info("Read all projects request.");
        return projectDao.readAll();
    }

    @Override
    public Project readById(int id) throws SQLException, NotFoundException {
        Project project = projectDao.readById(id);
        if (project == null) {
            logger.error("Project with id : " + id + " not found.");
            throw new NotFoundException("Project with id : " + id + " not found.");
        } else {
            logger.info("Getting project by id : " + id + ". " + project);
            return project;
        }
    }

    @Override
    public Project readByEmail(String email) throws SQLException, NotFoundException {
        return projectDao.readByEmail(email);
    }

    @Override
    public void create(Project project) throws SQLException, AlreadyExistException {
        if (isExists(project.getId())) {
            logger.error("Project with id : " + project.getId() + " already exists and can`t be created.");
            throw new AlreadyExistException("Project with id : " + project.getId() + " already exists.");
        } else {
            logger.info("Creating project : " + project);
            projectDao.create(project);
        }
    }

    @Override
    public void update(int id, Project current) throws SQLException, AlreadyExistException, NotFoundException {
        if (!(isExists(id))) {
            logger.error("Project with id : " + id + " not found and can`t be updated.");
            throw new NotFoundException("Project with id : " + id + " not found.");
        } else {
            projectDao.update(id, current);
            logger.info("Project with id : " + id + " was update by project : " + current);
        }
    }

    @Override
    public void delete(int id) throws SQLException, NotFoundException {
        if (isExists(id)) {
            projectDao.delete(id);
            logger.info("Project with id : " + id + " was deleted.");
        } else {
            logger.error("Project with id : " + id + " not found and can`t be deleted.");
            throw new NotFoundException("Project with id : " + id + " not found.");
        }
    }

    private List<Project> getAll() throws SQLException {
        return projectDao.readAll();
    }

    private boolean isExists(int projectId) throws SQLException {
        boolean flag = false;
        for (Project project : getAll()) {
            if (project.getId() == projectId) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}