-- Ejercicio 1
-- Mostrar nombre de la comida y del item que tengan un descuento menos a 0.02

select name from items
inner join partof on items.itemid = partof.itemid
where partof.discount < 0.02