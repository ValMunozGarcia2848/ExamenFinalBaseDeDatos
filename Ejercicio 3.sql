-- Ejercicio 3
-- Sumar la cantidad usada con los ingredientes que empiecen con S

select sum(inventory) from ingredients
where name like 'S%' 