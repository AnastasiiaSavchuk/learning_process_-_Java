package service.impl;

import model.Worker;
import org.apache.log4j.Logger;
import service.WorkerService;
import util.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    private static final Logger logger = Logger.getLogger(WorkerServiceImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @SuppressWarnings("unchecked")
    @Override
    public List<Worker> readAll() {
        Query query = entityManager.createQuery("SELECT w FROM Worker w");
        logger.info("Read all workers request.");
        return (List<Worker>) query.getResultList();
    }

    @Override
    public Worker readById(int id) {
        logger.info("Getting worker by id : " + id + ". " + entityManager.find(Worker.class, id));
        return entityManager.find(Worker.class, id);
    }

    @Override
    public Worker readByData(String fullName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Worker> criteria = builder.createQuery(Worker.class);
        Root<Worker> from = criteria.from(Worker.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("fullName"), fullName));
        logger.info("Getting worker by full name : " + fullName + ". " + entityManager.createQuery(criteria).getSingleResult());
        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public void create(Worker worker) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(worker);
        entityManager.getTransaction().commit();
        logger.info("Creating worker : " + worker);

    }

    @Override
    public void delete(int id) {
        Worker worker = readById(id);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(worker);
        entityManager.getTransaction().commit();
        logger.info("Worker with id : " + id + " was deleted.");
    }
}