CREATE VIEW quantity_ingredients_by_item (item_id, quantity_ingredients)
AS
SELECT item_id, COUNT(ingredient_id) AS total_quantity
FROM ingredient_usages
GROUP BY item_id;