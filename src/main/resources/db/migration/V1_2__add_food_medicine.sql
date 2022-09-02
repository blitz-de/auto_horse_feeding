create table tab_food(
    food_id serial not null,
    food_name varchar(100),
    expiration_date timestamp, --  '2038-01-19 03:14:07' UTC
    grams_per_portion bigint default 100,
    --preference varchar(100), --
    food_left bigint default 1000,
    primary key(food_id)
);

create table tab_medicine(
    medicine_id serial not null,
    medicine_name varchar(100),
    expiration_date timestamp,
    quantity bigint,
    primary key(medicine_id)
);