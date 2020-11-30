package service;

import model.Project;
import util.AbstractCRUDOperations;

public interface ProjectService extends AbstractCRUDOperations<Project> {

    Project getByEmail(String email);
}