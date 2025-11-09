CREATE TABLE if not exists public.PERSONS
(
  name TEXT NOT NULL,
  surname TEXT NOT NULL,
  age INTEGER NOT NULL,
  phone_number TEXT,
  city_of_living TEXT NOT NULL,
  PRIMARY KEY (name, surname, age)
);

INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Ivan', 'Ivanoff', 32, '+7(999)555-55-55', 'CHEBOKSARI');
INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Konstantin', 'Petroff', 25, '+7(988)888-88-88', 'CHEREPOVETS');
INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Vasiliy', 'Smirnoff', 34, '+7(977)777-77-77', 'CHELYABINSK');
INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Galina', 'Galiulina', 28, '+7(933)654-32-10', 'CHERDIN');
INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Alexey', 'Kubarev', 50, '8(800)535-35-35', 'CHEHOV');
INSERT INTO public.PERSONS(name, surname, age, phone_number, city_of_living)
VALUES ('Ivan', 'Ischov', 44, '+7(999)555-44-33', 'CHEBOKSARI');
