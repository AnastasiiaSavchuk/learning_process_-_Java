package service.impl;

import dao.TeamLeadDao;
import dao.impl.TeamLeadDaoImpl;
import exception.AlreadyExistException;
import exception.NotFoundException;
import model.TeamLead;
import org.apache.log4j.Logger;
import service.TeamLeadService;

import java.sql.SQLException;
import java.util.List;

public class TeamLeadServiceImpl implements TeamLeadService {

    private TeamLeadDao teamLeadDao;
    private static final Logger logger = Logger.getLogger(TeamLeadServiceImpl.class);

    public TeamLeadServiceImpl() {
        teamLeadDao = new TeamLeadDaoImpl();
    }

    @Override
    public List<TeamLead> readAll() throws SQLException {
        logger.info("Read all team leads request.");
        return teamLeadDao.readAll();
    }

    @Override
    public TeamLead readById(int id) throws SQLException, NotFoundException {
        TeamLead teamLead = teamLeadDao.readById(id);
        if (teamLead == null) {
            logger.error("Team lead with id : " + id + " not found.");
            throw new NotFoundException("Team lead with id : " + id + " not found.");
        } else {
            logger.info("Getting team lead by id : " + id + ". " + teamLead);
            return teamLead;
        }
    }

    @Override
    public void create(TeamLead teamLead) throws SQLException, AlreadyExistException {
        if (isExists(teamLead.getId())) {
            logger.error("Team lead with id : " + teamLead.getId() + " already exists and can`t be created.");
            throw new AlreadyExistException("Team lead with id : " + teamLead.getId() + " already exists.");
        } else {
            logger.info("Creating team lead : " + teamLead);
            teamLeadDao.create(teamLead);
        }
    }

    @Override
    public void update(int id, TeamLead current) throws SQLException, AlreadyExistException, NotFoundException {
        if (!(isExists(id))) {
            logger.error("Team lead with id : " + id + " not found and can`t be updated.");
            throw new NotFoundException("Team lead with id : " + id + " not found.");
        } else {
            teamLeadDao.update(id, current);
            logger.info("Team lead with id : " + id + " was update by team lead : " + current);
        }
    }

    @Override
    public void delete(int id) throws SQLException, NotFoundException {
        if (isExists(id)) {
            teamLeadDao.delete(id);
            logger.info("Team lead with id : " + id + " was deleted.");
        } else {
            logger.error("Team lead with id : " + id + " not found and can`t be deleted.");
            throw new NotFoundException("Team lead with id : " + id + " not found.");
        }
    }

    private List<TeamLead> getAll() throws SQLException {
        return teamLeadDao.readAll();
    }

    private boolean isExists(int teamLeadId) throws SQLException {
        boolean flag = false;
        for (TeamLead teamLead : getAll()) {
            if (teamLead.getId() == teamLeadId) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}