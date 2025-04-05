create table login_emp(username varchar(255) primary key,password varchar(255));
insert into login_emp values('admin','admin');
create table emp_register(id int primary key ,name varchar(255),email varchar(255) unique,address varchar(255),
designation varchar(255),doj varchar(255),gender varchar(255),mobno long,salary float );

CREATE TABLE Payments (
      
    name VARCHAR2(100) NOT NULL,                                     
    card_number VARCHAR2(16) NOT NULL,                               
    expiry_date VARCHAR2(5) NOT NULL,                                
    cvv VARCHAR2(3) NOT NULL,                                        
    amount NUMBER(10, 2) NOT NULL,                                   
    payment_status VARCHAR2(20) NOT NULL                              
);
CREATE TABLE transaction_logs (
    log_id NUMBER ,
    card_number VARCHAR2(16) NOT NULL,
    amount NUMBER(10, 2) NOT NULL,
    status VARCHAR2(20) NOT NULL
);
CREATE DATABASE payment_db;

USE payment_db;

CREATE TABLE payments1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(16) NOT NULL,
    card_holder_name VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
