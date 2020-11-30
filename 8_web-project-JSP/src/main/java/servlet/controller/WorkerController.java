package servlet.controller;

import lombok.SneakyThrows;
import model.Worker;
import org.apache.log4j.Logger;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import service.WorkerService;
import service.impl.WorkerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/worker")
public class WorkerController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(WorkerController.class);
    private WorkerService workerService;

    public WorkerController() {
        workerService = new WorkerServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String fullName = req.getParameter("fullName");
        String title = req.getParameter("title");
        Integer salary = Integer.parseInt(req.getParameter("salary"));

        if (Objects.isNull(workerService.readByData(fullName))) {
            Worker worker = new Worker(fullName, title, salary);
            logger.info("POST create /worker request : " + worker);
            workerService.create(worker);

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");
        } else {
            logger.info("Worker : " + fullName + ", title : " + title + ", salary : " + salary + " was already created!");

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("To create");
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        logger.info("GET /worker by id : " + id);

        Worker worker = workerService.readById(id);
        logger.info("Worker : " + worker);

        req.setAttribute("worker", worker);
        req.getRequestDispatcher("workerById.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("PUT /worker request.");

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            logger.error(e);
        }

        try {
            JSONObject jsonObject = HTTP.toJSONObject(jb.toString());
            logger.info("Object : " + jsonObject);

            int oldId = jsonObject.getInt("oldId");
            String fullName = jsonObject.getString("fullName");
            String title = jsonObject.getString("title");
            int salary = jsonObject.getInt("salary");

            Worker worker = new Worker(oldId, fullName, title, salary);
            logger.info("Worker with id = " + oldId + ", updated into worker : " + worker);
            workerService.update(oldId, worker);

            resp.setContentType("text");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");

        } catch (JSONException e) {
            throw new IOException("Error parsing JSON request string");
        }
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("DELETE request : delete worker.");

        int workerId = Integer.parseInt(req.getParameter("workerId"));
        workerService.delete(workerId);
        logger.info("Deleted worker : " + workerId + " , from dataBase.");

        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
