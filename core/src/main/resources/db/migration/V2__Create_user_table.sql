use user_management;
create table users (
    id int not null primary key auto_increment,
    name varchar(50) not null,
    password VARCHAR(200) NOT  NULL,
    employeeId int ,
    FOREIGN KEY (employeeId) REFERENCES employees(id) ON DELETE CASCADE
);