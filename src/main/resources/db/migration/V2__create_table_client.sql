CREATE TABLE client
(
    client_id BIGINT NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (client_id)
);

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_USER FOREIGN KEY (client_id) REFERENCES users (user_id);