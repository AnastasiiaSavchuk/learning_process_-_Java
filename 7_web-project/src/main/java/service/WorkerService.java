package service;

import dao.WorkerDao;
import model.Worker;
import shared.AbstractCRUDOperations;

public interface WorkerService extends AbstractCRUDOperations<Worker>, WorkerDao {
}