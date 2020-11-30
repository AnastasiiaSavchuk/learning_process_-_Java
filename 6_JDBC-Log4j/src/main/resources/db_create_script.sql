drop database if exists project;
CREATE DATABASE IF NOT EXISTS project;
USE project;

CREATE TABLE IF NOT EXISTS project(
	project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	project_name VARCHAR(30) NOT NULL,
    budget INT NOT NULL
 );  

CREATE TABLE IF NOT EXISTS team_lead(
	team_lead_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    team_lead_full_name VARCHAR(40) NOT NULL,
    team_lead_date_of_birth DATE,
    team_lead_salary INT NOT NULL,
    FOREIGN KEY(project_id) REFERENCES project(project_id)
    );
    
CREATE TABLE IF NOT EXISTS developer(
	worker_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    worker_full_name VARCHAR(30) NOT NULL,
    worker_title VARCHAR(30) NOT NULL,
    worker_date_of_birth DATE,
    worker_salary INT NOT NULL,
    worker_salary INT NOT NULL,
    team_lead_id INT NOT NULL,
    FOREIGN KEY(team_lead_id) REFERENCES team_lead(team_lead_id)
);