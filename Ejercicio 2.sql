-- Ejercicio 2
-- Mostrar la orden más barata de las tiendas que se encuetran en el estado TX

select  ordernumber from orders
inner join stores on orders.storeid = stores.storeid
where stores.state ='TX'   
