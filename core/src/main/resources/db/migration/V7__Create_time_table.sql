CREATE TABLE time(
  id int NOT NULL auto_increment,
  day VARCHAR(50) not null ,
  courseId int ,
  coachId int ,
  PRIMARY KEY (id),
  FOREIGN KEY (courseId) REFERENCES courses(id) ON DELETE CASCADE,
  FOREIGN KEY (coachId) REFERENCES employees(id) ON DELETE CASCADE
)