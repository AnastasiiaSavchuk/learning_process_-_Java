package service;

import dao.ProjectDao;
import model.Project;
import shared.AbstractCRUDOperations;

public interface ProjectService extends AbstractCRUDOperations<Project>, ProjectDao {
}
