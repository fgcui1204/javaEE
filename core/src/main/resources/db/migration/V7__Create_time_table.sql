CREATE TABLE time(
  id int NOT NULL auto_increment,
  time VARCHAR(50) not null ,
  courseId int ,
  coachId int ,
  PRIMARY KEY (id),
  FOREIGN KEY (courseId) REFERENCES courses(id),
  FOREIGN KEY (coachId) REFERENCES employees(id)
)