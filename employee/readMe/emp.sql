drop table employee;
CREATE TABLE employee
( id number(10) NOT NULL,
  name varchar2(50) NOT NULL,
  age number(10) NOT NULL,
  CONSTRAINT employee_pk PRIMARY KEY (id)
);

select * from employee;

drop table users;
CREATE TABLE users
( id number(10) NOT NULL,
  username varchar2(50) NOT NULL,
   password varchar2(100) NOT NULL,
  role varchar2(50) NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (id)
);

INSERT INTO users
(id, username,password,role)
VALUES
(1, 'manohar','$2a$10$EW9ZNsU/QAMDZnzJrgQOLuoVAHzpA7tuQlT.FKjz8ggdhzhvNewxq','USER');
COMMIT;

select * from users;