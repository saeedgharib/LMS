
use lms;
CREATE TABLE login (
  Username varchar(30) NOT NULL, 
  Password varchar(30),
  PRIMARY KEY (Username) 
);
CREATE TABLE Student (
  Student_ID int  NOT NULL,
  Fname varchar(30),
  Lname varchar(30),
  Username varchar(30), 
  Password varchar(30),
  Email varchar(50),
  Age int,
  check (Age<=30),
  PRIMARY KEY (Student_ID) 
);
CREATE TABLE Teacher (
  Teacher_ID int  NOT NULL,
  Fname varchar(30),
  Lname varchar(30),
  Username varchar(30), 
  Password varchar(30),
  Email varchar(50),
  PRIMARY KEY (Teacher_ID) 
);
CREATE TABLE Admin (
  Admin_ID int Not null,
  Fname varchar(30),
  Lname varchar(30),
  Username varchar(30), 
  Password varchar(30),
  Email varchar(50),
  PRIMARY KEY (Admin_ID) 
  
);
CREATE TABLE Result (
  Result_ID int  NOT NULL,
  Student_ID int NOT NULL,
  Course_ID int NOT NULL,
  Quiz_Marks int,
 Assignment_Marks int, 
 
  PRIMARY KEY (Result_ID) ,
   Foreign Key(Student_ID) references Student(Student_ID),
   Foreign Key(Course_ID) references Course(Course_ID)
);

CREATE TABLE Course (
  Course_ID int  NOT NULL,
  Course_name varchar(30),
  course_contents varchar(30),
  PRIMARY KEY (Course_ID) 
);

CREATE TABLE Content (
  Content_ID int  NOT NULL,
  Course_ID int NOT NULL,
  Pdf_Lecture_description varchar(500),
  PRIMARY KEY (Content_ID) ,
  Foreign Key(Course_ID) references Course(Course_ID)
);


CREATE TABLE Quiz (
  Quiz_ID int NOT NULL,
  Course_ID int NOT NULL,
  Questions varchar(150),
  Answers varchar(150),
  PRIMARY KEY (Quiz_ID) ,
  Foreign Key(Course_ID) references Course(Course_ID)
);

INSERT INTO login
VALUES('Shahwaiz','abc123');
INSERT INTO login
VALUES('kashif','password');



INSERT INTO Student
VALUES(10,'Muhammad','Saeed','saeed123','root','maliksaeed54321@gmail.com',23);
INSERT INTO Student
VALUES(11,'Shahwaiz','Iqbal','shawaiz','demo','shahwaiz@gmail.com',22);
INSERT INTO Student
VALUES(12,'kashif','kashif','saeed123','root','kashif@gmail.com',23);

INSERT INTO Teacher
VALUES(10,'Muhammad','Saeed','saeed123','root','maliksaeed54321@gmail.com');
INSERT INTO Teacher
VALUES(11,'Shahwaiz','Iqbal','shawaiz','demo','shahwaiz@gmail.com');
INSERT INTO Teacher
VALUES(12,'kashif','kashif','saeed123','root','kashif@gmail.com');

INSERT INTO Admin
VALUES(10,'Muhammad','Saeed','saeed123','root','maliksaeed54321@gmail.com');
INSERT INTO Admin
VALUES(11,'Shahwaiz','Iqbal','shawaiz','demo','shahwaiz@gmail.com');
INSERT INTO Admin
VALUES(12,'kashif','kashif','saeed123','root','kashif@gmail.com');





Update Student set Fname='Gharib' where Student_ID=10;
Update Admin set Username='Gharib' where Admin_ID=12;
commit;

Delete from Teacher where Teacher_ID=10;
Delete from Teacher where Teacher_ID=12;

rollback ;


Truncate login;


Drop table quiz;


select * from Student;
select * from Teacher;
select * from Admin;
select * from login;
select * from result;
select * from content;
select * from quiz;
