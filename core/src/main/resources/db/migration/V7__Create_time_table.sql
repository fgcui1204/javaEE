CREATE TABLE time(
  id int NOT NULL auto_increment,
  time VARCHAR(50) not null ,
  customer_courseId int ,
  coachId int ,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_courseId) REFERENCES customer_course(id),
  FOREIGN KEY (coachId) REFERENCES employees(id)
)