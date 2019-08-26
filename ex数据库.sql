CREATE DATABASE exam;
DROP DATABASE exam
CREATE TABLE t_class(
	id INT PRIMARY KEY AUTO_INCREMENT,
	className VARCHAR(20),
	starTime DATE
);

INSERT INTO t_class(className,starTime)VALUES
('一班','2019-01-12'),
('二班','2018-12-13'),
('三班','2018-11-14')

SELECT * FROM t_class
SELECT s.studentName,s.sex,s.birthday,c.className FROM t_class c JOIN t_student s ON c.id=s.classId 

SELECT s.*,COUNT(classId) countNum FROM  t_class c JOIN t_student s ON c.id=s.classId GROUP BY classId

CREATE TABLE t_student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	studentName VARCHAR(20),
	sex ENUM('男','女'),
	birthday DATE,
	classId INT
)
INSERT INTO t_student(studentName,sex,birthday,classId)VALUES
('张三','男','1996-01-02',1),
('李四','男','1997-02-04',2),
('王五','女','1995-03-06',3),
('赵六','男','1994-04-08',1),
('田七','女','1996-05-10',2),
('钱八','女','1997-06-12',3),
('张三丰','男','1998-07-14',1),
('张无忌','男','1995-08-16',2),
('令狐冲','男','1994-09-18',3),
('岳不群','男','1993-10-20',1),
('梅超风','女','1992-11-22',3)

SELECT s.*,c.className FROM t_student s JOIN t_class c ON s.classId=c.id WHERE 1=1 


SELECT * FROM t_student
