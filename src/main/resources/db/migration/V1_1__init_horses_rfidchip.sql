create table tab_horses(
    guid serial not null,
    name varchar(100),
    nickname varchar(100),
    color varchar(100),
    breed_name varchar(100),
    type varchar(100),
    doctor_id bigint,
    stableman_id bigint,
    chip_id bigint,
    food_id bigint,
    medicine_id bigint,
    primary key(guid)
);

create table tab_rfid_chip(
    chip_id serial not null,
    time_of_released_food time, -- insert into tab_rfid_chip values('08:20')- time(LocalTime)
    feeding_station varchar(100),
    food_released boolean default false,
    operation_done boolean default false,
    had_breakfast boolean default false,
    had_launch boolean default false,
    had_dinner boolean default false,
    primary key(chip_id)
);

