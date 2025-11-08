CREATE TABLE if not exists public.CUSTOMERS
(
    id           SERIAL PRIMARY KEY,
    name         TEXT    NOT NULL,
    surname      TEXT    NOT NULL,
    age          INTEGER NOT NULL,
    phone_number TEXT
);
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Ivan', 'Ivanoff', 32, '+7(999)555-55-55');
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Konstantin', 'Petroff', 25, '+7(988)888-88-88');
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Vasiliy', 'Smirnoff', 34, '+7(977)777-77-77');
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Galina', 'Galiulina', 28, '+7(933)654-32-10');
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Alexey', 'Kubarev', 50, '8(800)535-35-35');
INSERT INTO public.CUSTOMERS(name, surname, age, phone_number)
VALUES ('Ivan', 'Ischov', 44, '+7(999)555-44-33');

CREATE TABLE if not exists public.ORDERS
(
    id           SERIAL PRIMARY KEY,
    date         DATE,
    customer_id  INTEGER NOT NULL,
    product_name TEXT    NOT NULL,
    amount       INTEGER NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES public.Customers (Id)
    );
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-31', 1, 'Tovar_1', 199);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-30', 2, 'Jidkost', 159);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-29', 5, 'Tverdost', 79);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-31', 4, 'Gadost', 119);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-30', 3, 'Gadost', 119);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-10-29', 5, 'Strange Thing', 899);
INSERT INTO public.ORDERS(date, customer_id, product_name, amount)
VALUES ('2025-11-01', 6, 'Tverdost', 89);