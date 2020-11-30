package service.impl;

import dao.WorkerDao;
import dao.impl.WorkerDaoImpl;
import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Worker;
import org.apache.log4j.Logger;
import service.WorkerService;

import java.sql.SQLException;
import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    private static final Logger logger = Logger.getLogger(WorkerServiceImpl.class);
    private WorkerDao workerDao;

    public WorkerServiceImpl() {
        workerDao = new WorkerDaoImpl();
    }

    @Override
    public List<Worker> readAll() throws SQLException {
        logger.info("Read all workers request.");
        return workerDao.readAll();
    }

    @Override
    public Worker readByData(String full_name) throws SQLException {
        return workerDao.readByData(full_name);
    }

    @Override
    public Worker readById(int id) throws SQLException, NotFoundException {
        Worker worker = workerDao.readById(id);
        if (worker == null) {
            logger.error("Worker with id : " + id + " not found.");
            throw new NotFoundException("Worker with id : " + id + " not found.");
        } else {
            logger.info("Getting worker by id : " + id + ". " + worker);
            return worker;
        }
    }

    @Override
    public void create(Worker worker) throws SQLException, AlreadyExistException {
        if (isExists(worker.getId())) {
            logger.error("Worker with id : " + worker.getId() + " already exists and can`t be created.");
            throw new AlreadyExistException("Worker with id : " + worker.getId() + " already exists.");
        } else {
            logger.info("Creating worker : " + worker);
            workerDao.create(worker);
        }
    }

    @Override
    public void update(int id, Worker current) throws SQLException, NotFoundException, AlreadyExistException {
        if (!(isExists(id))) {
            logger.error("Worker with id : " + id + " not found and can`t be updated.");
            throw new NotFoundException("Project with id : " + id + " not found.");
        } else {
            workerDao.update(id, current);
            logger.info("Worker with id : " + id + " was update by worker : " + current);
        }
    }

    @Override
    public void delete(int id) throws SQLException, NotFoundException {
        if (isExists(id)) {
            workerDao.delete(id);
            logger.info("Worker with id : " + id + " was deleted.");
        } else {
            logger.error("Worker with id : " + id + " not found and can`t be deleted.");
            throw new NotFoundException("Worker with id : " + id + " not found.");
        }
    }

    private List<Worker> getAll() throws SQLException {
        return workerDao.readAll();
    }

    private boolean isExists(int projectId) throws SQLException {
        boolean flag = false;
        for (Worker worker : getAll()) {
            if (worker.getId() == projectId) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}