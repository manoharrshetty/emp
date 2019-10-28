
drop sequence emp_seq;
drop table emp;
drop table dept;
drop sequence users_seq;
drop sequence dept_seq;
drop table users;

CREATE TABLE dept (
    dept_id      number(10) NOT NULL,
    name   VARCHAR(40)     NOT NULL,

    last_modified_date DATE default SYSDATE,
    version number (10) default 1,
    CONSTRAINT dept_pk PRIMARY KEY (dept_id),
    
    CONSTRAINT dept_uk1 UNIQUE(name)

);



CREATE TABLE emp
( emp_id number(10) NOT NULL,
 first_name  VARCHAR2(100)     NOT NULL,
 last_name   VARCHAR2(100)     NOT NULL,
 gender   char(1)     NOT NULL,
  birth_date  DATE        NOT NULL,
  hire_date   DATE         NOT NULL,
  dept_id number(10) not null,
  last_modified_date DATE default SYSDATE,
  version number (10) default 1,
  CONSTRAINT emp_pk PRIMARY KEY (emp_id),
  constraint fk_dept_id foreign key (dept_id) references dept (dept_id)
);

CREATE SEQUENCE emp_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE dept_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 

select * from employee;
SELECT emp_seq.nextval FROM dual;





CREATE TABLE users
( users_Id number(10) NOT NULL,
  name varchar2(50) NOT NULL,
  password varchar2(100) NOT NULL,
  role varchar2(50) NOT NULL,
  version number (10) default 1,
  CONSTRAINT users_pk PRIMARY KEY (users_id)
);

CREATE SEQUENCE users_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


INSERT INTO users
(users_id, name,password,role)
VALUES
(users_seq.nextval, 'manohar','$2a$10$EW9ZNsU/QAMDZnzJrgQOLuoVAHzpA7tuQlT.FKjz8ggdhzhvNewxq','ADMIN');
commit;



select * from users;
select * from emp;
SELECT * FROM DEPT;





INSERT INTO emp (emp_id, first_name,last_name,gender,birth_date,hire_date,dept_id) VALUES (emp_seq.nextval, 'kalpana','shetty','M',TO_DATE('29-APR-1979','DD-MON-YYYY'),TO_DATE('29-APR-2019','DD-MON-YYYY'),1);
INSERT INTO emp (emp_id, first_name,last_name,gender,birth_date,hire_date,dept_id) VALUES (emp_seq.nextval, 'keval','shetty','M',TO_DATE('29-APR-1982','DD-MON-YYYY'),TO_DATE('29-APR-2019','DD-MON-YYYY'),1);
COMMIT;


select * from dept
--create user
--create USER emp_user IDENTIFIED BY  "K!delq6w";

--grant connect,resource to emp_user;



SELECT          
first_name as emp_first_name,    
last_name  as emp_last_name,    
gender     as emp_gender,    
birth_date as emp_birth_date,    
hire_date  as emp_hire_date,    
e.version    ,    
e.last_modified_date as emp_last_modified_date    ,         
d.dept_id   as dept_id,    
name as dept_name,    
d.version    as dept_version,    
d.last_modified_date as dept_last_modified_date        
FROM 
emp e left join dept d on  e.dept_id = d.dept_id     
where 1 = 1            
AND 
emp_id = 1

select * from dept
