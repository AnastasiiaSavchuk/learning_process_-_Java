package util;

public class SQLConstants {

    public static final String GET_ALL_PROJECTS = "SELECT * FROM web_project.project";
    public static final String GET_PROJECT_BY_ID = "SELECT * FROM web_project.project WHERE id = ?";
    public static final String GET_PROJECT_BY_EMAIL = "SELECT * FROM web_project.project WHERE email = ?";
    public static final String INSERT_PROJECT = "INSERT INTO web_project.project (id, name, budget, email, password) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_PROJECT = "UPDATE web_project.project SET id = ?, name = ?, budget = ?, email = ?, password = ? WHERE (id = ?)";
    public static final String DELETE_PROJECT = "DELETE FROM web_project.project WHERE id = ?";

    public static final String GET_ALL_TEAM_LEADS = "SELECT * FROM web_project.team_lead";
    public static final String GET_TEAM_LEAD_BY_ID = "SELECT * FROM web_project.team_lead WHERE id = ?";
    public static final String INSERT_TEAM_LEAD = "INSERT INTO web_project.team_lead (id, full_name, date_of_birth, salary) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_TEAM_LEAD = "UPDATE web_project.team_lead SET id = ?, full_name = ?, date_of_birth = ?, salary = ? WHERE (id = ?)";
    public static final String DELETE_TEAM_LEAD = "DELETE FROM web_project.team_lead WHERE id = ?";

    public static final String GET_ALL_WORKER = "SELECT * FROM web_project.worker";
    public static final String GET_WORKER_BY_ID = "SELECT * FROM web_project.worker WHERE id = ?";
    public static final String INSERT_WORKER = "INSERT INTO web_project.worker (id, full_name, title, salary) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_WORKER = "UPDATE web_project.worker SET id = ?, full_name = ?, title = ?, salary = ? WHERE (id = ?)";
    public static final String DELETE_WORKER = "DELETE FROM web_project.worker WHERE id = ?";

    public static final String GET_ALL_TEAM_LEADS_WORKERS = "SELECT * FROM web_project.team_lead_worker";
    public static final String GET_TEAM_LEAD_WORKER_BY_ID = "SELECT * FROM web_project.team_lead_worker WHERE team_lead_id = ? AND worker_id = ?";
    public static final String INSERT_TEAM_LEAD_WORKER = "INSERT INTO web_project.team_lead_worker (team_lead_id, worker_id) VALUES (?, ?);";
    public static final String DELETE_TEAM_LEAD_WORKER = "DELETE FROM web_project.team_lead_worker WHERE team_lead_id = ? AND worker_id = ?";
}