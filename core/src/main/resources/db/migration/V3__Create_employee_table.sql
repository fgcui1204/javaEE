create table employees (
    id int not null auto_increment,
    role VARCHAR(50) NOT NULL ,
    userId int,
    PRIMARY KEY(id),
    FOREIGN KEY (userId) REFERENCES users(id)
);