package service.impl;

import model.Project;
import org.apache.log4j.Logger;
import service.ProjectService;
import util.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> readAll() {
        Query query = entityManager.createQuery("SELECT p FROM Project p");
        logger.info("Read all projects request." + (List<Project>) query.getResultList());
        return (List<Project>) query.getResultList();
    }

    @Override
    public Project readById(int id) {
        logger.info("Getting project by id : " + id + ". " + entityManager.find(Project.class, id));
        return entityManager.find(Project.class, id);
    }

    @Override
    public Project getByEmail(String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> from = criteria.from(Project.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("email"), email));
        logger.info("Getting project by email : " + email + ". " + entityManager.createQuery(criteria).getSingleResult());
        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public void create(Project project) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        logger.info("Creating project : " + project);
    }

    @Override
    public void delete(int id) {
        Project project = readById(id);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(project);
        entityManager.getTransaction().commit();
        logger.info("Project with id : " + id + " was deleted.");
    }
}