package service;

import dao.TeamLeadDao;
import model.TeamLead;
import shared.AbstractCRUDOperations;

public interface TeamLeadService extends AbstractCRUDOperations<TeamLead>, TeamLeadDao {
}
