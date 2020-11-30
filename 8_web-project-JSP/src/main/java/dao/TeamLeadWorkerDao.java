package dao;

import exception.AlreadyExistException;
import exception.NotFoundException;
import model.TeamLeadWorker;

import java.sql.SQLException;
import java.util.List;

public interface TeamLeadWorkerDao {

    List<TeamLeadWorker> readAll() throws SQLException;

    TeamLeadWorker readById(int team_lead_id, int worker_id) throws SQLException, NotFoundException;

    void create(TeamLeadWorker teamLeadWorker) throws SQLException, AlreadyExistException;

    void delete(TeamLeadWorker teamLeadWorker) throws SQLException, NotFoundException;
}
