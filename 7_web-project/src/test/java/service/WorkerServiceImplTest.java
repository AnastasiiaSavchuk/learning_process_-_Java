package service;

import exception.AlreadyExistException;
import exception.NotFoundException;
import model.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.impl.WorkerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class WorkerServiceImplTest {

    private static WorkerService workerService;

    @BeforeAll
    static void init() {
        workerService = new WorkerServiceImpl();
    }

    @Test
    @DisplayName("Read all workers")
    public void readAll() throws SQLException {
        List<Worker> workerList = workerService.readAll();
        Assertions.assertTrue(workerList.size() >= 1);
    }

    @Test
    @DisplayName("Create, update and delete new project")
    public void createAndUpdateAndDeleteTest() throws SQLException, AlreadyExistException, NotFoundException {
        final int createId = 111;

        Worker testWorker = new Worker(createId, "Test_CREATE_worker", "Test", 0);
        workerService.create(testWorker);
        Worker actual = workerService.readById(createId);
        Assertions.assertEquals(testWorker, actual);

        Worker current = new Worker(createId, "Test_UPDATE_worker", "Test-1", 0);
        workerService.update(createId, current);
        Assertions.assertEquals(current, workerService.readById(createId));

        workerService.delete(createId);
        Assertions.assertThrows(NotFoundException.class, () -> workerService.readById(createId));
    }
}
