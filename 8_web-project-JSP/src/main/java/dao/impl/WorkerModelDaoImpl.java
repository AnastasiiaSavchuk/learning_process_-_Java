package dao.impl;

import dao.WorkerModelDao;
import util.MySqlConnector;
import util.SQLConstants;
import util.model.WorkerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerModelDaoImpl implements WorkerModelDao {

    private Connection connection;

    public WorkerModelDaoImpl() {
        connection = MySqlConnector.getConnection();
    }

    @Override
    public List<WorkerModel> getWorkerByTeamlead(int teamLeadId) throws SQLException {
        List<WorkerModel> workerList = new ArrayList<>();
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_WORKERS_FROM_TEAM_LEAD)) {
            statement.setInt(1, teamLeadId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                WorkerModel worker = new WorkerModel(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("title"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("worker_count"));
                workerList.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet.close();
        }
        return workerList;
    }
}
