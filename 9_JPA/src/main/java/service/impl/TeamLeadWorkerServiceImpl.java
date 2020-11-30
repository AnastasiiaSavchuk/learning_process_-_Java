package service.impl;

import model.TeamLead;
import model.TeamLeadWorker;
import model.Worker;
import org.apache.log4j.Logger;
import service.TeamLeadService;
import service.TeamLeadWorkerService;
import service.WorkerService;
import util.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TeamLeadWorkerServiceImpl implements TeamLeadWorkerService {

    public static final Logger logger = Logger.getLogger(TeamLeadWorkerServiceImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();
    private static TeamLeadService teamLeadService = new TeamLeadServiceImpl();
    private static WorkerService workerService = new WorkerServiceImpl();


    @SuppressWarnings("unchecked")
    @Override
    public List<TeamLeadWorker> readAll() {
        Query query = entityManager.createQuery("SELECT tlw FROM TeamLeadWorker tlw");
        logger.info("Read all team lead worker (s) request");
        return (List<TeamLeadWorker>) query.getResultList();
    }

    @Override
    public TeamLeadWorker readByIds(int teamLeadId, int workerId) {
        TeamLead teamLead = teamLeadService.readById(teamLeadId);
        Worker worker = workerService.readById(workerId);
        logger.info("Getting teamLeadWorker by teamLeadId : " + teamLeadId + " and workerId " + workerId);
        return entityManager.find(TeamLeadWorker.class, new TeamLeadWorker(teamLead, worker, 0));
    }

    @Override
    public void create(int teamLeadId, int workerId, int count) {
        TeamLead teamLead = teamLeadService.readById(teamLeadId);
        Worker worker = workerService.readById(workerId);

        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(new TeamLeadWorker(teamLead, worker, count));
        entityManager.getTransaction().commit();
        logger.info("Creating TeamLeadWorker with teamLeadId : " + teamLeadId + " and workerId : " + workerId);
    }

    @Override
    public void delete(int teamLeadId, int workerId) {
        TeamLeadWorker teamLeadWorker = readByIds(teamLeadId, workerId);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(teamLeadWorker);
        entityManager.getTransaction().commit();
        logger.info("TeamLeadWorker with id : " + teamLeadId + " and workerId " + workerId + " was deleted");
    }
}