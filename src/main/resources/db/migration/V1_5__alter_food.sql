alter table tab_horses
add foreign key(food_id) references tab_food(food_id); -- oder foodPreference

alter table tab_horses
add foreign key(medicine_id) references tab_medicine(medicine_id);