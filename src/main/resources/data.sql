insert into customer(id, name) values (1234, 'Steve');
insert into customer(id, name) values (1235, 'Patrick');
insert into customer(id, name) values (1592, 'Ramesh');

insert into transaction(id, description, amount, save_date, customer_id) values (1001, 'Transaction 1001', 100, TO_DATE('2022-06-17 10:20:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1002, 'Transaction 1002', 50, TO_DATE('2022-06-01 10:30:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1003, 'Transaction 1003', 120, TO_DATE('2022-05-10 10:40:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1004, 'Transaction 1004', 175, TO_DATE('2022-05-07 10:50:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1005, 'Transaction 1005', 65, TO_DATE('2022-05-05 10:40:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1006, 'Transaction 1006', 210, TO_DATE('2022-04-03 10:25:10', 'yyyy-MM-dd'), 1234);
insert into transaction(id, description, amount, save_date, customer_id) values (1009, 'Transaction 1009', 42, TO_DATE('2022-04-18 10:35:10', 'yyyy-MM-dd'), 1234);

insert into transaction(id, description, amount, save_date, customer_id) values (1200, 'Transaction 1200', 25, TO_DATE('2022-06-01 12:20:10', 'yyyy-MM-dd'), 1235);
insert into transaction(id, description, amount, save_date, customer_id) values (1201, 'Transaction 1201', 80, TO_DATE('2022-05-05 15:00:10', 'yyyy-MM-dd'), 1235);
insert into transaction(id, description, amount, save_date, customer_id) values (1202, 'Transaction 1202', 116, TO_DATE('2022-05-10 11:30:10', 'yyyy-MM-dd'), 1235);

insert into transaction(id, description, amount, save_date, customer_id) values (1008, 'Transaction 1008', 200, TO_DATE('2022-06-17 10:20:10', 'yyyy-MM-dd'), 1592);