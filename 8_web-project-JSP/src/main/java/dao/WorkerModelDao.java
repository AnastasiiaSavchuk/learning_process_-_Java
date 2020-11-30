package dao;

import util.model.WorkerModel;

import java.sql.SQLException;
import java.util.List;

public interface WorkerModelDao {

    List<WorkerModel> getWorkerByTeamlead(int teamLeadId) throws SQLException;
}
