package service.impl;

import dao.WorkerModelDao;
import dao.impl.WorkerModelDaoImpl;
import org.apache.log4j.Logger;
import service.WorkerModalService;
import util.model.WorkerModel;

import java.sql.SQLException;
import java.util.List;

public class WorkerModalServiceImpl implements WorkerModalService {

    private static final Logger logger = Logger.getLogger(WorkerModalServiceImpl.class);
    private WorkerModelDao workerModelDao;

    public WorkerModalServiceImpl() {
        workerModelDao = new WorkerModelDaoImpl();
    }

    @Override
    public List<WorkerModel> getWorkerByTeamlead(int teamLeadId) throws SQLException {
        logger.info("Read all Workers for TeamLead request");
        return workerModelDao.getWorkerByTeamlead(teamLeadId);
    }
}
