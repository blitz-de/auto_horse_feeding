--create table preferred_food_by_horse (
--guid int REFERENCES tab_horses(guid) on update cascade on delete cascade,
--food_id int REFERENCES tab_food(food_id) on update cascade on delete cascade,
--amount numeric not null default 1,
--constraint food_horse_pkey primary key (guid, food_id)

--);