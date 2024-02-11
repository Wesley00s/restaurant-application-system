CREATE TABLE ingredient
(
    ingredient_id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    ingredient_name   VARCHAR(255)                            NOT NULL,
    quantity_in_stock INTEGER                                 NOT NULL,
    CONSTRAINT pk_ingredient PRIMARY KEY (ingredient_id)
);