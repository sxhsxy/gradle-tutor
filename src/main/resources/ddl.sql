CREATE TABLE department
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE sys_user
(
    id SERIAL PRIMARY KEY NOT NULL,
    login_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    department_id INT,
    FOREIGN KEY ( department_id ) REFERENCES department ( id )
);
