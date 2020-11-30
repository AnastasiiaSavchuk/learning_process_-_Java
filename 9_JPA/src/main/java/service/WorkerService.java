package service;

import model.Worker;
import util.AbstractCRUDOperations;

public interface WorkerService extends AbstractCRUDOperations<Worker> {

    Worker readByData(String fullName);
}