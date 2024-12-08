CREATE DATABASE school;
USE school;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    roll_no VARCHAR(100),
    marks INT
);
SHOW TABLES;
DESCRIBE student;
INSERT INTO student (id, name, address, roll_no, mark)
VALUES 
    (1, 'saish', '123 Main St', 101, 85.5),
    (2, 'prince', '456 Elm St', 102, 90.0),
    (3, 'Rakesh ', '789 Oak St', 103, 78.5),
    (4, 'john', '321 Maple St', 104, 88.0);


SELECT * FROM student;
DESCRIBE student;
SELECT * FROM student;



