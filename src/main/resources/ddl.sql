DROP TABLE sys_user;
DROP TABLE sys_role;
DROP TABLE sys_permission;
DROP TABLE department;
DROP TABLE organization;
DROP TABLE hibernate_sequence_table;

CREATE TABLE department
(
    id bigint PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE sys_user
(
    id bigint PRIMARY KEY NOT NULL,
    login_name VARCHAR(128) NOT NULL UNIQUE ,
    password VARCHAR(256) NOT NULL,
    name VARCHAR(128) NOT NULL,
    gender VARCHAR(16),
    department_id INT,
    FOREIGN KEY ( department_id ) REFERENCES department ( id )
);

CREATE TABLE organization
(
  id bigint PRIMARY KEY NOT NULL,
  name VARCHAR(128) NOT NULL,
  pid INT NOT NULL,
  type VARCHAR(64)
);

CREATE TABLE sys_role
(
  id bigint PRIMARY KEY ,
  name VARCHAR(128) UNIQUE
);

CREATE TABLE sys_permission
(
  id bigint NOT NULL,
  name VARCHAR(128) UNIQUE
);

CREATE TABLE  hibernate_sequence_table (
  id bigserial NOT NULL,
  sequence_name varchar(255) NOT NULL,
  next_val bigint NOT NULL,
  PRIMARY KEY  (id)
);

ALTER TABLE sys_user
ALTER COLUMN login_name TYPE VARCHAR(128),
ALTER COLUMN password TYPE VARCHAR(256),
ALTER COLUMN name TYPE VARCHAR(128),
ALTER COLUMN gender TYPE VARCHAR(16);