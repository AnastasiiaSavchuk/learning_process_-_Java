package dao.impl;

import dao.TeamLeadWorkerDao;
import model.TeamLeadWorker;
import util.MySqlConnector;
import util.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamLeadWorkerDaoImpl implements TeamLeadWorkerDao {

    private Connection connection;


    public TeamLeadWorkerDaoImpl() {
        connection = MySqlConnector.getConnection();
    }

    @Override
    public List<TeamLeadWorker> readAll() throws SQLException {
        List<TeamLeadWorker> teamLeadWorkerList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_TEAM_LEADS_WORKERS)) {
            while (resultSet.next()) {
                TeamLeadWorker teamLeadWorker = new TeamLeadWorker(resultSet.getInt("team_lead_id"),
                        resultSet.getInt("worker_id"), resultSet.getInt("worker_count"));
                teamLeadWorkerList.add(teamLeadWorker);
            }
        }
        return teamLeadWorkerList;
    }

    @Override
    public TeamLeadWorker readById(int team_lead_id, int worker_id) throws SQLException {
        ResultSet resultSet = null;
        TeamLeadWorker teamLeadWorker = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_TEAM_LEAD_WORKER_BY_ID)) {
            statement.setInt(1, team_lead_id);
            statement.setInt(2, worker_id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                teamLeadWorker = new TeamLeadWorker(resultSet.getInt("team_lead_id"),
                        resultSet.getInt("worker_id"), resultSet.getInt("worker_count"));
            }
        }
        return teamLeadWorker;
    }

    @Override
    public void create(TeamLeadWorker teamLeadWorker) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_TEAM_LEAD_WORKER)) {
            statement.setInt(1, teamLeadWorker.getTeamLeadId());
            statement.setInt(2, teamLeadWorker.getWorkerId());
            statement.setInt(3, teamLeadWorker.getWorkerCount());
            statement.execute();
        }
    }

    @Override
    public void delete(TeamLeadWorker teamLeadWorker) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_TEAM_LEAD_WORKER)) {
            statement.setInt(1, teamLeadWorker.getTeamLeadId());
            statement.setInt(2, teamLeadWorker.getWorkerId());
            statement.execute();
        }
    }
}