package service;

import util.model.WorkerModel;

import java.sql.SQLException;
import java.util.List;

public interface WorkerModalService {

    List<WorkerModel> getWorkerByTeamlead(int teamLeadId) throws SQLException;
}
