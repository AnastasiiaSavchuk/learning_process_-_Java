package service;

import model.TeamLeadWorker;

import java.util.List;

public interface TeamLeadWorkerService {

    List<TeamLeadWorker> readAll();

    TeamLeadWorker readByIds(int teamLeadId, int workerId);

    void create(int teamLeadId, int workerId, int count);

    void delete(int teamLeadId, int workerId);
}