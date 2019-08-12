drop table dept_emp;
drop table employee;
drop table department;
drop table users;

CREATE TABLE employee
( emp_id number(10) NOT NULL,
 first_name  VARCHAR2(100)     NOT NULL,
 last_name   VARCHAR2(100)     NOT NULL,
 gender   char(1)     NOT NULL,
  birth_date  DATE            NOT NULL,
  hire_date   DATE            NOT NULL,
  CONSTRAINT employee_pk PRIMARY KEY (emp_id)
);

INSERT INTO employee (emp_id, first_name,last_name,gender,birth_date,hire_date) VALUES (1, 'manohar','shetty','M',TO_DATE('29-APR-1979','DD-MON-YYYY'),TO_DATE('29-APR-2019','DD-MON-YYYY'));
COMMIT;
select * from employee;


CREATE TABLE department (
    dept_id      number(10) NOT NULL,
    dept_name   VARCHAR(40)     NOT NULL,
    CONSTRAINT department_pk PRIMARY KEY (dept_id),
    CONSTRAINT department_uk1 UNIQUE(dept_name)

);


CREATE TABLE dept_emp (
    dept_emp_id number(10) not null,
    emp_id      number(10) NOT NULL,
    dept_id     number(10) NOT NULL,
    from_date   DATE        NOT NULL,
    to_date     DATE        NOT NULL,
    CONSTRAINT dept_emp_pk PRIMARY KEY (dept_emp_id),
    CONSTRAINT dept_emp_uk1 UNIQUE(emp_id,dept_id),
    CONSTRAINT dept_emp_fk1     FOREIGN KEY (emp_id)     REFERENCES employee(emp_id),
    CONSTRAINT dept_emp_fk2     FOREIGN KEY (dept_id)     REFERENCES department(dept_id) 
);


CREATE TABLE users
( usersId number(10) NOT NULL,
  name varchar2(50) NOT NULL,
  password varchar2(100) NOT NULL,
  role varchar2(50) NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (users_id)
);




INSERT INTO users
(users_id, name,password,role)
VALUES
(1, 'manohar','$2a$10$EW9ZNsU/QAMDZnzJrgQOLuoVAHzpA7tuQlT.FKjz8ggdhzhvNewxq','USER');
COMMIT;


select * from users;






--create user
--create USER emp_user IDENTIFIED BY  "K!delq6w";

--grant connect,resource to emp_user;