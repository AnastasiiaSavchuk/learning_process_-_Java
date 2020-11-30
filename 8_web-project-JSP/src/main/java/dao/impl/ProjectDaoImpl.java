package dao.impl;

import dao.ProjectDao;
import model.Project;
import util.MySqlConnector;
import util.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    private Connection connection;

    public ProjectDaoImpl() {
        connection = MySqlConnector.getConnection();
    }

    @Override
    public List<Project> readAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_PROJECTS)) {
            while (resultSet.next()) {
                Project project = new Project(resultSet.getInt("id"),
                        resultSet.getString("role"),
                        resultSet.getString("name"),
                        resultSet.getInt("budget"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
                projectList.add(project);
            }
        }
        return projectList;
    }

    @Override
    public Project readById(int id) throws SQLException {
        ResultSet resultSet = null;
        Project project = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_PROJECT_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                project = new Project(resultSet.getInt("id"),
                        resultSet.getString("role"),
                        resultSet.getString("name"),
                        resultSet.getInt("budget"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
        } finally {
            resultSet.close();
        }
        return project;
    }

    @Override
    public Project readByEmail(String email) throws SQLException {
        Project project = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_PROJECT_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                project = new Project(resultSet.getInt("id"),
                        resultSet.getString("role"),
                        resultSet.getString("name"),
                        resultSet.getInt("budget"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
        }
        return project;
    }

    @Override
    public void create(Project project) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_PROJECT)) {
            statement.setInt(1, project.getId());
            statement.setString(2, project.getRole());
            statement.setString(3, project.getName());
            statement.setInt(4, project.getBudget());
            statement.setString(5, project.getEmail());
            statement.setString(6, project.getPassword());
            statement.execute();
        }
    }

    @Override
    public void update(int id, Project current) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_PROJECT)) {
            statement.setInt(1, current.getId());
            statement.setString(2, current.getRole());
            statement.setString(3, current.getName());
            statement.setInt(4, current.getBudget());
            statement.setString(5, current.getEmail());
            statement.setString(6, current.getPassword());
            statement.setInt(7, id);
            statement.execute();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_PROJECT)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}