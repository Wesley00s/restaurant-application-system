CREATE TABLE request
(
    id_request        UUID                        NOT NULL,
    date_time_request TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    status            SMALLINT                    NOT NULL,
    client_id         BIGINT,
    item_id           BIGINT,
    table_id          BIGINT,
    employ_id         BIGINT,
    CONSTRAINT pk_request PRIMARY KEY (id_request)
);

ALTER TABLE request
    ADD CONSTRAINT FK_REQUEST_ON_CLIENT_ID FOREIGN KEY (client_id) REFERENCES client (client_id);

ALTER TABLE request
    ADD CONSTRAINT FK_REQUEST_ON_EMPLOY_ID FOREIGN KEY (employ_id) REFERENCES employee (employee_id);

ALTER TABLE request
    ADD CONSTRAINT FK_REQUEST_ON_ITEM_ID FOREIGN KEY (item_id) REFERENCES item (item_id);

ALTER TABLE request
    ADD CONSTRAINT FK_REQUEST_ON_TABLE_ID FOREIGN KEY (table_id) REFERENCES eating_table (table_id);