package dao;

import model.Worker;
import shared.AbstractCRUDOperations;

import java.sql.SQLException;

public interface WorkerDao extends AbstractCRUDOperations<Worker> {

    Worker readByData(String full_name) throws SQLException;
}
