create table employees (
    id int not null auto_increment,
    role VARCHAR(50) NOT NULL ,
    name VARCHAR(50) NOT NULL ,
    sex VARCHAR(4) not null,
    mail VARCHAR(50) not null,
    age int not null,
    PRIMARY KEY(id)
);