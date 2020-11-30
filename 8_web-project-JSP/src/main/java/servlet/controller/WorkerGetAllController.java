package servlet.controller;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.Worker;
import org.apache.log4j.Logger;
import service.WorkerService;
import service.impl.WorkerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/getWorker")
public class WorkerGetAllController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(WorkerGetAllController.class);
    private WorkerService workerService;

    public WorkerGetAllController() {
        workerService = new WorkerServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Worker> workerList = workerService.readAll();
        String json = new Gson().toJson(workerList);

        logger.info("GET /getWorker request.");
        logger.info("Workers : " + json);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
