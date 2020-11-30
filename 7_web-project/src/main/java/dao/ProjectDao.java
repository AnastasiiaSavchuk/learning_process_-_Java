package dao;

import exception.NotFoundException;
import model.Project;
import shared.AbstractCRUDOperations;

import java.sql.SQLException;

public interface ProjectDao extends AbstractCRUDOperations<Project> {

    Project readByEmail(String email) throws SQLException, NotFoundException;
}
