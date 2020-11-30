USE it_system;
SELECT * FROM it_system.team_lead;
SELECT * FROM it_system.project;
SELECT * FROM it_system.team;
SELECT * FROM it_system.task;
SELECT * FROM it_system.project_task;

#1) Вивести всіх тім лідів, які молодші 25 років :
SELECT * FROM it_system.team_lead WHERE team_lead_age < 25;

#2) Вивести всі проекти в яких ім’я проекту закінчується на “la” і бюджет проекту більший 10000 :
SELECT * FROM it_system.project WHERE project_name LIKE "%la" AND budget > 10000;

#3) Відсортувати всі команди за полем class :
SELECT * FROM it_system.team ORDER BY team_class ASC;

#4) Вивести всю інформацію про проект з найбільшим бюджетом :
 SELECT * FROM it_system.project WHERE budget = (SELECT max(budget) FROM it_system.project);

#5) Вивести стільки кімнат (class) є в офісі :
SELECT COUNT(team_class) AS count_team_class FROM it_system.team;

#6) Вивести загальну суму бюджету для всіх проектів.
SELECT sum(budget) AS sum_budget FROM it_system.project;

#7) Вивести всі команди у яких розмір команди від 10 до 20.
SELECT * FROM it_system.team WHERE team_size BETWEEN 10 AND 20;

#8) Перейменувати поле age в таблиці team_lead на поле team_lead_age.
ALTER TABLE it_system.team_lead RENAME COLUMN team_lead_age TO lead_age;

#9) Вивести всі команди у яких team_lead Андрій.
SELECT team.team_name, team.team_size FROM team INNER JOIN team_lead
ON(team_lead.team_lead_id = team.team_lead_id)
WHERE team_lead.team_lead_name = "Andriy";

#10) Вивести всі таски для проекту з ім’ям “Adidas”.
SELECT * FROM it_system.task INNER JOIN it_system.project_task
ON (task.task_id = project_task.task_id)
INNER JOIN it_system.project
ON (project_task.project_id = project.project_id)
WHERE project_name = "Adidas";

#11) Вивести всі проекти, для яких є таска “Black card”
SELECT * FROM it_system.project INNER JOIN it_system.project_task
ON (project.project_id = project_task.project_id)
INNER JOIN it_system.task
ON (project_task.task_id = task.task_id)
WHERE task_name = "Black card";

#12) Вивести команду, яка працює над проектом “Bank Project” :
SELECT * FROM it_system.team
INNER JOIN it_system.team_lead ON (team.team_lead_id = team_lead.team_lead_id)
INNER JOIN it_system.project ON (team_lead.team_lead_id = project.project_id)
WHERE it_system.project.project_name = "Bank Project";

#13) Вивести проект, над яким працює команда “First team”
SELECT * FROM it_system.team INNER JOIN it_system.team_lead
ON (team.team_lead_id = team_lead.team_lead_id)
INNER JOIN it_system.project
ON (team_lead.team_lead_id = project.project_id)
WHERE it_system.team.team_name = "First team";

#14) Вивести тім ліда, який має проект “Online store”
SELECT * FROM it_system.team_lead INNER JOIN it_system.project
ON (team_lead.team_lead_id = project.project_id )
WHERE project_name = "Online store";