insert into customer(customer_id,customer_name,address,country,postalcode) 
values(1000,'marwa','alex','alex','12345');
insert into customer(customer_id,customer_name,address,country,postalcode) 
values(1001,'anaa','alex','alex','12345');
insert into customer(customer_id,customer_name,address,country,postalcode) 
values(1002,'loujain','alex','alex','12345');
insert into customer(customer_id,customer_name,address,country,postalcode) 
values(1003,'noureen','alex','alex','12345');

insert into orders  (order_id,order_date,customer_id) 
values(100,'2019-02-01 10:00:00',1000);
insert into orders  (order_id,order_date,customer_id) 
values(101,'2019-02-01 10:00:00',1001);
insert into orders  (order_id,order_date,customer_id) 
values(102,'2019-02-01 10:00:00',1002);
insert into orders  (order_id,order_date,customer_id) 
values(103,'2019-02-01 10:00:00',1000);
insert into orders  (order_id,order_date,customer_id) 
values(104,'2019-02-01 10:00:00',1003);





INSERT INTO OrderDetails VALUES(1,10248,11,12);
INSERT INTO OrderDetails VALUES(2,10248,42,10);
INSERT INTO OrderDetails VALUES(3,10248,72,5);