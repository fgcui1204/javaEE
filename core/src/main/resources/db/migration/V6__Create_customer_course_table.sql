create table customer_course (
    id int not null auto_increment,
    customerId int NOT NULL ,
    courseId int NOT NULL ,
    PRIMARY KEY(id),
    FOREIGN KEY (customerId) REFERENCES customers(id),
    FOREIGN KEY (courseId) REFERENCES courses(id)
);