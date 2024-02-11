CREATE TABLE client
(
    client_id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    client_name  VARCHAR(255)                            NOT NULL,
    number_phone VARCHAR(255)                            NOT NULL,
    email        VARCHAR(255)                            NOT NULL,
    cpf          VARCHAR(255)                            NOT NULL,
    city         VARCHAR(255)                            NOT NULL,
    street       VARCHAR(255)                            NOT NULL,
    zip_code     VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (client_id)
);

ALTER TABLE client
    ADD CONSTRAINT uc_client_cpf UNIQUE (cpf);

ALTER TABLE client
    ADD CONSTRAINT uc_client_email UNIQUE (email);