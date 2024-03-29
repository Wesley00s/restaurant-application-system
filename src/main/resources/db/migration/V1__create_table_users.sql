CREATE TABLE users
(
    user_id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_name    VARCHAR(255)                            NOT NULL,
    number_phone VARCHAR(255)                            NOT NULL,
    email        VARCHAR(255)                            NOT NULL,
    password     VARCHAR(255)                            NOT NULL,
    cpf          VARCHAR(255)                            NOT NULL,
    role         SMALLINT                                NOT NULL,
    city         VARCHAR(255)                            NOT NULL,
    street       VARCHAR(255)                            NOT NULL,
    zip_code     VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_cpf UNIQUE (cpf);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);