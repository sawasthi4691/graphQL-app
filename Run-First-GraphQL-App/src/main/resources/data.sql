DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS ADDRESS;

CREATE TABLE ADDRESS(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   street VARCHAR(255),
   city VARCHAR(255)
);

CREATE TABLE STUDENT(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   email VARCHAR(255),
   address_id int,
   foreign key (address_id) references ADDRESS(ID)
);

CREATE TABLE subject(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(255),
    marks_obtained VARCHAR(255),
    student_id int,
    foreign key (student_id) references STUDENT(ID)
);


INSERT INTO address (street,city) VALUES ('Happy Street','Delhi'),('2nd Street','Mumbai'),('3rd Street','Delhi'),('any street','Mumbai');
INSERT INTO student (first_name,last_name,email,address_id) VALUES ('John','Smith','john@gmail.com',1),('Virat','Dave','virat@gmail.com',2),('Steve','Martin','steve@gmail.com',3),('Sachin','Kumar','sachin@gmail.com',4);
INSERT INTO subject (subject_name,marks_obtained,student_id) VALUES ('Java',80,1),('MySQL',70,1),('Java',80,2),('MySQL',70,2),('MongoDB',70,2),('MySQL',70,3),('MongoDB',70,3),('Java',60,4),('MongoDB',50,4);

