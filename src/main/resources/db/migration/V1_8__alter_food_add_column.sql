--alter table tab_food
--add column food_left bigint constraint default 1000;

--alter table tab_rfid_chip
--alter column time_of_released_food type timestamp; -- timestamp == LoalDateTime, time == LocalTime

--alter table tab_rfid_chip
--add column had_breakfast boolean constraint default false;
--alter table tab_rfid_chip
--add column had_launch boolean constraint default false;
--alter table tab_rfid_chip
--add column had_dinner boolean constraint default false;
--alter table tab_rfid_chip
--add column operation_done boolean constraint default false;
