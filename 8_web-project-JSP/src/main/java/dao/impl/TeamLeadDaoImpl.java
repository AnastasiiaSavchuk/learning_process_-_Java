package dao.impl;

import dao.TeamLeadDao;
import model.TeamLead;
import util.MySqlConnector;
import util.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamLeadDaoImpl implements TeamLeadDao {

    private Connection connection;

    public TeamLeadDaoImpl() {
        connection = MySqlConnector.getConnection();
    }

    @Override
    public List<TeamLead> readAll() throws SQLException {
        List<TeamLead> teamLeadList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_TEAM_LEADS)) {
            while (resultSet.next()) {
                TeamLead teamLead = new TeamLead(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getInt("salary"));
                teamLeadList.add(teamLead);
            }
        }
        return teamLeadList;
    }

    @Override
    public TeamLead readById(int id) throws SQLException {
        ResultSet resultSet = null;
        TeamLead teamLead = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_TEAM_LEAD_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                teamLead = new TeamLead(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getInt("salary"));
            }
        } finally {
            resultSet.close();
        }
        return teamLead;
    }

    @Override
    public void create(TeamLead teamLead) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_TEAM_LEAD)) {
            statement.setInt(1, teamLead.getId());
            statement.setString(2, teamLead.getFullName());
            statement.setString(3, teamLead.getDateOfBirth());
            statement.setInt(4, teamLead.getSalary());
            statement.execute();
        }
    }

    @Override
    public void update(int id, TeamLead current) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_TEAM_LEAD)) {
            statement.setInt(1, current.getId());
            statement.setString(2, current.getFullName());
            statement.setString(3, current.getDateOfBirth());
            statement.setInt(4, current.getSalary());
            statement.setInt(5, id);
            statement.execute();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_TEAM_LEAD)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}