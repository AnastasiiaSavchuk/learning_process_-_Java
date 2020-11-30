package service.impl;

import model.TeamLead;
import org.apache.log4j.Logger;
import service.TeamLeadService;
import util.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TeamLeadServiceImpl implements TeamLeadService {

    private static final Logger logger = Logger.getLogger(TeamLeadServiceImpl.class);
    private EntityManager entityManager = FactoryManager.getEntityManager();

    @SuppressWarnings("unchecked")
    @Override
    public List<TeamLead> readAll() {
        Query query = entityManager.createQuery("SELECT tl FROM TeamLead tl");
        logger.info("Read all team leads request.");
        return (List<TeamLead>) query.getResultList();
    }

    @Override
    public TeamLead readById(int id) {
        logger.info("Getting team lead by id : " + id + ". " + entityManager.find(TeamLead.class, id));
        return entityManager.find(TeamLead.class, id);
    }

    @Override
    public void create(TeamLead teamLead) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(teamLead);
        entityManager.getTransaction().commit();
        logger.info("Creating team lead : " + teamLead);

    }

    @Override
    public void delete(int id) {
        TeamLead teamLead = readById(id);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(teamLead);
        entityManager.getTransaction().commit();
        logger.info("Team lead with id : " + id + " was deleted.");
    }
}
