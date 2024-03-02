CREATE TABLE employee
(
    employee_id     BIGINT NOT NULL,
    hiring_date date   NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (employee_id)
);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_USER FOREIGN KEY (employee_id) REFERENCES users (user_id);