use user_management;
create table users (
    id int not null primary key auto_increment,
    name varchar(50) not null,
    sex VARCHAR(4) not null,
    mail VARCHAR(50) not null,
    age int not null
);