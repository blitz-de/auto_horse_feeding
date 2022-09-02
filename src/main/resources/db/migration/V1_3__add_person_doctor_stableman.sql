--create table tab_person(
    --person_id SERIAL,
--   id SERIAL,
 --   firstname varchar(100),
--    lastname varchar(100),
 --   address varchar(100),
--    plz varchar(100),
 --   gender varchar(100),
   -- city varchar(100),
    --age varchar(100),
    --occupation varchar(100),

   -- primary key(id)-
--);

create table tab_stableman(
    --stableman_id SERIAL,
    id SERIAL,
    firstname varchar(100),
    lastname varchar(100),
    address varchar(100),
    plz varchar(100),
    gender varchar(100),
    city varchar(100),
    age varchar(100),
    occupation varchar(100),

    primary key(id)
);

create table tab_doctor(
    --doctor_id serial,
    id SERIAL,
    firstname varchar(100),
    lastname varchar(100),
    address varchar(100),
    plz varchar(100),
    gender varchar(100),
    city varchar(100),
    age varchar(100),
    medical_degree varchar(100),
    occupation varchar(100),
    --guid bigint,
    primary key(id)
)
--INHERITS (tab_person);

--  doctor_id SERIAL,
