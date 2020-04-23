CREATE TABLE institution(
   id SERIAL PRIMARY KEY,
   inst_name VARCHAR (50) NOT NULL,
   inst_type VARCHAR (50) NOT NULL,
   opening_hours VARCHAR (355) NOT NULL,
   phone VARCHAR (50) NOT NULL,
   address VARCHAR (355) UNIQUE NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);

INSERT INTO institution (inst_name, inst_type, opening_hours, phone, address, updated_at) 
VALUES ('Gruzin.by', 'CAFFE', 'ПН-ЧТ, ВС 11:00-23:00 ПТ-СБ 11:00-00:00', '+375 (29) 355-31-02', 'ул. Ложинская, 4 БЦ Порт м. Уручье', NULL);
INSERT INTO institution (inst_name, inst_type, opening_hours, phone, address, updated_at) 
VALUES ('Gruzin.by', 'CAFFE', 'ПН-ВС c 11:00-23:00', '+375 (29) 621-10-44', 'ул. Октябрьская, 16', NULL);
INSERT INTO institution (inst_name, inst_type, opening_hours, phone, address, updated_at) 
VALUES ('Gruzin.by', 'CAFFE', 'ПН-ВС c 11:00-23:00', '+375 (44) 554-74-44', 'Пр-т Держинского, 119', NULL);

CREATE TABLE dish(
   id SERIAL PRIMARY KEY,
   dish_name VARCHAR (50) NOT NULL,
   dish_size VARCHAR (50) NOT NULL DEFAULT 'MIDDLE',
   dish_cost DECIMAL(5,2) NOT NULL,
   dish_weight INT NOT NULL,
   dish_note VARCHAR (355) NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note)
VALUES ('ХАЧАПУРИ МЕНГРЕЛЬСКИЙ', 'SMALL', 3.95, 180, 'Горячая лепешка с молодым грузинским сыром внутри');
INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note)
VALUES ('ХАЧАПУРИ МЕНГРЕЛЬСКИЙ', 'MIDDLE', 8.25, 350, 'Горячая лепешка с молодым грузинским сыром внутри');
INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note)
VALUES ('ХАЧАПУРИ МЕНГРЕЛЬСКИЙ', 'BIG', 15.35, 700, 'Горячая лепешка с молодым грузинским сыром внутри');
INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note)
VALUES ('ХАЧАПУРИ АДЖАРСКИЙ', 'SMALL', 5.45, 250, 'Горячая лепешка-лодочка с яйцом и молодым грузинским сыром');
INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note)
VALUES ('ХАЧАПУРИ АДЖАРСКИЙ', 'MIDDLE', 7.65, 350, 'Горячая лепешка-лодочка с яйцом и молодым грузинским сыром');
INSERT INTO dish (dish_name, dish_cost, dish_weight, dish_note)
VALUES ('ЧАХОХБИЛИ', 6.95, 300, 'Куриная грудка в томатном соусе с зеленью и рисом');
INSERT INTO dish (dish_name, dish_cost, dish_weight, dish_note)
VALUES ('ХИНКАЛИ КЛАССИЧЕСКИЙ', 1.95, 90, 'Мешочек теста с начинкой из говядины, свинины, специй и зелени');
INSERT INTO dish (dish_name, dish_cost, dish_weight, dish_note)
VALUES ('СУП ХАРЧО +ЛАВАШ ЖЖЕТ!', 5.95, 300, 'Острый суп на томатной пасте с говядиной, грузинскими приправами и рисом');

CREATE TABLE inst_menu(
   id SERIAL PRIMARY KEY,
   inst_id INT NOT NULL references institution(id),
   dish_id INT NOT NULL references dish(id),
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   
   updated_at TIMESTAMP
);

INSERT INTO inst_menu (inst_id, dish_id) VALUES (1,1); 
INSERT INTO inst_menu (inst_id, dish_id) VALUES (1,2);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (1,3);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (1,4);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (1,5);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (2,1);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (2,2);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (2,3);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (2,6);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (2,7);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (3,4);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (3,5);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (3,6);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (3,7);
INSERT INTO inst_menu (inst_id, dish_id) VALUES (3,8);
