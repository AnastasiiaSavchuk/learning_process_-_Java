package service.impl;

import dao.TeamLeadWorkerDao;
import dao.impl.TeamLeadWorkerDaoImpl;
import exception.AlreadyExistException;
import exception.NotFoundException;
import model.TeamLeadWorker;
import org.apache.log4j.Logger;
import service.TeamLeadWorkerService;

import java.sql.SQLException;
import java.util.List;

public class TeamLeadWorkerServiceImpl implements TeamLeadWorkerService {

    public static final Logger logger = Logger.getLogger(TeamLeadWorkerServiceImpl.class);
    private TeamLeadWorkerDao teamLeadWorkerDao;

    public TeamLeadWorkerServiceImpl() {
        teamLeadWorkerDao = new TeamLeadWorkerDaoImpl();
    }

    @Override
    public List<TeamLeadWorker> readAll() throws SQLException {
        logger.info("Read all team lead worker (s) request");
        return teamLeadWorkerDao.readAll();
    }

    @Override
    public TeamLeadWorker readById(int team_lead_id, int worker_id) throws SQLException, NotFoundException {
        TeamLeadWorker teamLeadWorker = teamLeadWorkerDao.readById(team_lead_id, worker_id);
        if (teamLeadWorker == null) {
            logger.error("TeamLeadWorker with team_lead_id : " + team_lead_id +
                    " and worker_id : " + worker_id + " not found");
            throw new NotFoundException("TeamLeadWorker with team_lead_id : " + team_lead_id +
                    " and worker_id : " + worker_id + " not found");
        } else {
            logger.info("Getting teamLeadWorker with team_lead_id : " + team_lead_id +
                    " and worker_id : " + worker_id + ". " + teamLeadWorker);
            return teamLeadWorker;
        }
    }

    @Override
    public void create(TeamLeadWorker teamLeadWorker) throws SQLException, AlreadyExistException {
        if (isExists(teamLeadWorker)) {
            logger.error("TeamLeadWorker with team_lead_id : " + teamLeadWorker.getTeamLeadId() +
                    " and worker_id : " + teamLeadWorker.getWorkerId() + " already exists and can`t be created");
            throw new AlreadyExistException("TeamLeadWorker with team_lead_id : " + teamLeadWorker.getTeamLeadId() +
                    " and worker_id : " + teamLeadWorker.getWorkerId() + " already exists");
        } else {
            logger.info("Creating TeamLeadWorker : " + teamLeadWorker);
            teamLeadWorkerDao.create(teamLeadWorker);
        }
    }

    @Override
    public void delete(TeamLeadWorker teamLeadWorker) throws SQLException, NotFoundException {
        if (!isExists(teamLeadWorker)) {
            logger.error("TeamLeadWorker with team_lead_id : " + teamLeadWorker.getTeamLeadId() +
                    " and worker_id : " + teamLeadWorker.getWorkerId() + " not found and can`t be deleted");
            throw new NotFoundException("TeamLeadWorker with team_lead_id : " + teamLeadWorker.getTeamLeadId() +
                    " and worker_id : " + teamLeadWorker.getWorkerId() + " not found");
        } else {
            teamLeadWorkerDao.delete(teamLeadWorker);
            logger.info("TeamLeadWorker with team_lead_id : " + teamLeadWorker.getTeamLeadId() +
                    " and worker_id : " + teamLeadWorker.getWorkerId() + " was deleted");
        }
    }

    private List<TeamLeadWorker> getAll() throws SQLException {
        return teamLeadWorkerDao.readAll();
    }

    private boolean isExists(TeamLeadWorker teamLeadWorker) throws SQLException {
        boolean flag = false;
        for (TeamLeadWorker entity : getAll()) {
            if (teamLeadWorker.getTeamLeadId() == entity.getTeamLeadId() &&
                    teamLeadWorker.getWorkerId() == entity.getWorkerId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
