drop database if exists web_project;
CREATE DATABASE IF NOT EXISTS web_project;
USE web_project;

CREATE TABLE IF NOT EXISTS project(
	project_id INT NOT NULL PRIMARY KEY,
	project_name VARCHAR(30) NOT NULL,
    budget INT NOT NULL,
    project_email VARCHAR(45) NOT NULL,
	project_password VARCHAR(15) NOT NULL
 );

CREATE TABLE IF NOT EXISTS team_lead(
	team_lead_id INT NOT NULL PRIMARY KEY,
    team_lead_full_name VARCHAR(50) NOT NULL,
    team_lead_date_of_birth DATE,
    team_lead_salary INT NOT NULL,
	FOREIGN KEY(team_lead_id) REFERENCES project(project_id)
    );

CREATE TABLE IF NOT EXISTS worker(
	worker_id INT NOT NULL PRIMARY KEY,
    worker_full_name VARCHAR(50) NOT NULL,
    worker_title VARCHAR(10) NOT NULL,
    worker_salary INT NOT NULL,
    team_lead_id INT NOT NULL,
    FOREIGN KEY(team_lead_id) REFERENCES team_lead(team_lead_id)
);