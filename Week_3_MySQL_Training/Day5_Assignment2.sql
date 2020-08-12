create database student_db2;

use student_db2;

-- student table

create table student_info(id int PRIMARY KEY AUTO_INCREMENT, first_name varchar(45) NOT NULL, last_name varchar(45) NOT NULL, 
created_by int NOT NULL, updated_by int, created_on datetime default now(), updated_on datetime);
desc student_info;

-- courses table
create table course_info(id int PRIMARY KEY AUTO_INCREMENT, course_name varchar(45) UNIQUE  NOT NULL,
created_by int NOT NULL, updated_by int, created_on datetime default now(), updated_on datetime);

-- score table 
create table score_info(id int PRIMARY KEY AUTO_INCREMENT, student_id int NOT NULL, course_id int NOT NULL, 
score int NOT NULL, start_date_time datetime NOT NULL, end_date_time datetime NOT NULL,
created_by int NOT NULL, updated_by int, created_on datetime default now(), updated_on datetime, 
FOREIGN KEY(student_id) REFERENCES student_info(id), FOREIGN KEY (course_id) REFERENCES course_info(id));

desc score_info;

-- insert in student table
insert into student_info(first_name, last_name, created_by) values ("Monica","Geller",1), ("Chandler","Bing",2), ("Phoebe","Buffay",1), 
("Joey","Tribbiani",2), ("Rachel","Green",1), ("Ross","Geller",2) ; 

-- insert in courses' table
insert into course_info(course_name, created_by) values("Java", 1), ("SQl", 2), ("Operating System",1), ("Data Structures",2), ("Machine Learning",1);


-- insert in scores' table
insert into score_info(student_id, course_id, score, start_date_time, end_date_time, created_by) values(2,3, 87, '2020-05-05 14:29:36', '2020-06-05 14:29:36',1),
(3,2,89, '2020-07-11 12:29:36',now(),2), (1,3, 85, '2020-05-30 12:00:0','2020-06-30 12:30:00',1) ,
(4,5, 85,'2020-06-08 12:00:0', '2020-07-08 12:00:0',1),(5,2, 75, '2020-05-07 12:00:0','2020-06-07 12:30:36',2),
(6,4, 82, '2020-05-05 12:00:0','2020-06-05 12:00:00',1), (1,3, 96, '2020-03-30 12:00:0','2020-04-30 12:30:00',1),
(4,4, 92, '2020-05-25 12:00:0','2020-06-25 12:00:00',2), (5,4, 85,'2020-07-07 12:00:0','2020-08-07 12:30:00',1),
(4,5, 75, '2020-04-08 12:00:0','2020-05-08 12:00:00',1), (1,2, 95, '2020-07-20 12:00:0','2020-08-20 12:30:00',1),
(6,5, 80, '2020-04-28 12:00:0','2020-05-25 12:00:00',2),(2,5, 97, '2020-05-08 12:00:0','2020-06-09 12:00:00',2),
(5,5, 90, '2020-03-30 12:00:0','2020-04-30 12:30:00',1), (2,2, 90, '2020-06-05 14:29:36', '2020-07-05 14:29:36',1),
(3,1, 93, '2020-05-08 12:00:0','2020-06-09 12:00:00',2),(3,1, 90, '2020-03-30 12:00:0','2020-04-30 12:30:00',1),
(5,1, 84, '2020-06-05 14:29:36', '2020-07-05 12:29:36',1);

-- all tables info
select * from student_info; 
select *from course_info;
select *from score_info order by student_id, course_id, end_date_time;

-- Average of all the scores obtained by all the students for any single given course
select c.course_name, avg(sc.score) as avg_score from score_info sc
JOIN course_info c ON sc.course_id = c.id 
where sc.course_id = 3;

-- Scorecard for any given student that shows all his scores for all of the courses
select s.id, s.first_name, sc.score, c.course_name from student_info s 
JOIN score_info sc ON s.id = sc.student_id 
JOIN course_info c ON sc.course_id = c.id 
where s.id = 1;

-- Scorecard for any given student that shows only his best score per course.
select s.id, s.first_name, max(sc.score) as max_score, c.course_name from student_info s 
JOIN score_info sc ON s.id = sc.student_id 
JOIN course_info c ON sc.course_id = c.id 
where (s.id = 1) group by c.course_name ;

-- Scorecard for any given student that shows only his latest score per course. 
select * from score_info where student_id = 1 order by student_id, course_id, end_date_time;

select s.id as student_id, s.first_name, c.id as course_id, c.course_name, sc.score, sc.end_date_time from student_info s 
JOIN score_info sc ON s.id = sc.student_id 
JOIN course_info c ON c.id = sc.course_id where  (c.id, sc.end_date_time) in (
   select course_id, max(end_date_time)
    from score_info where student_id = 1
    group by course_id
);

-- The best score obtained (by any students) per course along with the name of the student. Kind of the like topperss of each course.
select s.id as student_id, s.first_name as topper,c.id as course_id, c.course_name , max(sc.score) as max_course_score from student_info s 
INNER JOIN score_info sc ON s.id = sc.student_id 
JOIN course_info c ON c.id =sc.course_id
group by c.course_name order by c.id;
