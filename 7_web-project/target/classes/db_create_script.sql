drop database if exists web_project;

CREATE DATABASE IF NOT EXISTS web_project;
USE web_project;

CREATE TABLE IF NOT EXISTS project(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
    budget INT NOT NULL,
    email VARCHAR(45) NOT NULL,
	password VARCHAR(15) NOT NULL
 );

CREATE TABLE IF NOT EXISTS team_lead(
	id INT NOT NULL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    salary INT NOT NULL,
	FOREIGN KEY(id) REFERENCES project(id)
    );

CREATE TABLE IF NOT EXISTS developer(
	id INT NOT NULL PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    title VARCHAR(10) NOT NULL,
    salary INT NOT NULL
);

CREATE TABLE IF NOT EXISTS team_lead_worker(
	team_lead_id INT NOT NULL,
	worker_id INT NOT NULL,
	CONSTRAINT id PRIMARY KEY(team_lead_id, worker_id),
	FOREIGN KEY (team_lead_id) REFERENCES team_lead(id),
	FOREIGN KEY (worker_id) REFERENCES developer(id)
);