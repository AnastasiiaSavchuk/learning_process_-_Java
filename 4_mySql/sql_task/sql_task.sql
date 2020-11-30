drop database if exists it_system;
CREATE DATABASE IF NOT EXISTS it_system;
USE it_system;

CREATE TABLE IF NOT EXISTS team_lead(
	team_lead_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    team_lead_name VARCHAR(30) NOT NULL,
    team_lead_surname VARCHAR(30),
    team_lead_age INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS project(
	project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	project_name VARCHAR(30) NOT NULL,
    details TEXT,
    budget INT NOT NULL,
    importence TEXT,
	FOREIGN KEY(project_id) REFERENCES team_lead(team_lead_id)
 );

CREATE TABLE IF NOT EXISTS team(
	team_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(30) NOT NULL,
    team_size INT NOT NULL,
    team_class VARCHAR(30) NOT NULL,
    team_lead_id INT NOT NULL,
    FOREIGN KEY(team_lead_id) REFERENCES team_lead(team_lead_id)
);

CREATE TABLE IF NOT EXISTS task(
	task_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR (30) NOT NULL
);

CREATE TABLE IF NOT EXISTS project_task(
	project_id INT NOT NULL,
    task_id INT NOT NULL,
    CONSTRAINT id PRIMARY KEY (project_id, task_id),
    FOREIGN KEY(project_id) REFERENCES project(project_id),
    FOREIGN KEY(task_id) REFERENCES task(task_id)
);