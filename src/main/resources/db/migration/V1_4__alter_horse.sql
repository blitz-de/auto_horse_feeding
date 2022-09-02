alter table tab_horses
add CONSTRAINT fk_tab_horses_tab_doctor FOREIGN KEY(doctor_id) references tab_doctor(id); -- oder doctorID

alter table tab_horses
add foreign key(stableman_id) references tab_stableman(id); -- oder stablemanID

alter table tab_horses
add foreign key(chip_id) references tab_rfid_chip(chip_id); -- oder rfidChip

