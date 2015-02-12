DROP TABLE sys_user;
DROP TABLE sys_role;
DROP TABLE sys_permission;
DROP TABLE department;
DROP TABLE organization;
DROP TABLE hibernate_sequence_table;
DROP TABLE sys_role_permission;
DROP TABLE sys_user_role;

CREATE TABLE  hibernate_sequence_table (
  id bigint NOT NULL auto_increment ,
  sequence_name varchar(255) NOT NULL,
  next_val bigint NOT NULL,
  PRIMARY KEY  (id)
);

CREATE TABLE department
(
    id bigint PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL UNIQUE
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
  name VARCHAR(128) UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE sys_role_permission
(
  role_id bigint NOT NULL,
  permission_id bigint NOT NULL,
  PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE sys_user_role
(
  user_id bigint NOT NULL ,
  role_id bigint NOT NULL ,
  PRIMARY KEY (user_id, role_id)
);



CREATE TABLE sys_user
(
  id BIGINT PRIMARY KEY NOT NULL,
  login_name VARCHAR(128) NOT NULL,
  password VARCHAR(256) NOT NULL,
  name VARCHAR(128) NOT NULL,
  gender VARCHAR(16),
  department_id BIGINT,
  FOREIGN KEY ( department_id ) REFERENCES department ( id )
);

CREATE TABLE commodity
(
  id BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(64) NOT NULL,
  type_number VARCHAR(128),
  unit VARCHAR(64)
);
