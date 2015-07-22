create table courses (
    id int not null auto_increment,
    name VARCHAR(50) NOT NULL ,
    coachId INT ,
    time varchar(50),
    FOREIGN KEY (coachId) REFERENCES employees(id),
    PRIMARY KEY(id)
);