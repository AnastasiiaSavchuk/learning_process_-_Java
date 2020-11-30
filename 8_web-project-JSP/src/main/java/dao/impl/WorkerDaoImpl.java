package dao.impl;

import dao.WorkerDao;
import model.Worker;
import util.MySqlConnector;
import util.SQLConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    private Connection connection;

    public WorkerDaoImpl() {
        connection = MySqlConnector.getConnection();
    }

    @Override
    public List<Worker> readAll() throws SQLException {
        List<Worker> workerList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_WORKER)) {
            while (resultSet.next()) {
                Worker worker = new Worker(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("title"),
                        resultSet.getInt("salary"));
                workerList.add(worker);
            }
        }
        return workerList;
    }

    @Override
    public Worker readByData(String full_name) throws SQLException {
        Worker worker = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_WORKER_BY_DATA)) {
            statement.setString(1, full_name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                worker = new Worker(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("title"),
                        resultSet.getInt("salary"));
            }
        }
        return worker;
    }

    @Override
    public Worker readById(int id) throws SQLException {
        ResultSet resultSet = null;
        Worker worker = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_WORKER_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                worker = new Worker(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("title"),
                        resultSet.getInt("salary"));

            }
        } finally {
            resultSet.close();
        }
        return worker;
    }

    @Override
    public void create(Worker worker) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_WORKER)) {
            statement.setInt(1, worker.getId());
            statement.setString(2, worker.getFullName());
            statement.setString(3, worker.getTitle());
            statement.setInt(4, worker.getSalary());
            statement.execute();
        }
    }

    @Override
    public void update(int id, Worker current) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_WORKER)) {
            statement.setInt(1, current.getId());
            statement.setString(2, current.getFullName());
            statement.setString(3, current.getTitle());
            statement.setInt(4, current.getSalary());
            statement.setInt(5, id);
            statement.execute();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_WORKER)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}