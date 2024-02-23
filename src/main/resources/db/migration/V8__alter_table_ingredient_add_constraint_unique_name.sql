ALTER TABLE ingredient
    ADD CONSTRAINT uc_ingredient_ingredient_name UNIQUE (ingredient_name);