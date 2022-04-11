INSERT INTO airports (id, icao, location) VALUES (1001, 'EHGR', 'Gilze-Rijen');
INSERT INTO airports (id, icao, location) VALUES (1002, 'EHTE', 'Apledoorn');
INSERT INTO airports (id, icao, location) VALUES (1003, 'EHAL', 'Ameland');
INSERT INTO airports (id, icao, location) VALUES (1004, 'EHAM', 'Haarlemermeer');
INSERT INTO airports (id, icao, location) VALUES (1005, 'EHTE', 'Ameland');

INSERT INTO starting_methodes (id, title, unit, price) VALUES (1006, 'Winch', 1, 5);
INSERT INTO starting_methodes (id, title, unit, price) VALUES (1007, 'Tow', 'minute', 0.2);
INSERT INTO starting_methodes (id, title, unit, price) VALUES (1008,'Selfstarter', 0, 0);

-- INSERT INTO persons (id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country, email, phone) VALUES (2001, 'm', 'Marcel', 'Thijssen', '1964-08-19', 'straat', '3', '4817SX', 'Breda', 'Nederland', 'start@e-mailadres.nl', '0612306345');
-- INSERT INTO persons (id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country, email, phone) VALUES (2002, 'v', 'Femmie', 'Jansen', '1964-08-19', 'Straatnaam', '993', '4811VC', 'Bredea', 'Nederland', 'begin@mailadres.nl', '0691256345');
-- INSERT INTO persons (id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country, email, phone) VALUES (2003, 'm', 'Toonie', 'de Vries', '1964-08-19', 'Naamstraat', '55a', '4811VC', 'Rotjeknor', 'Nederland', 'begin@mailadres.nl', '0634506109');

INSERT INTO type_of_memberships (id, title, costs_per_month) VALUES (1009, 'pupil ≤18', 56);
INSERT INTO type_of_memberships (id, title, costs_per_month) VALUES (1010, 'pupil 18+', 69);
INSERT INTO type_of_memberships (id, title, costs_per_month) VALUES (1012, 'GPL ≤18', 12.50);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1013, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1014, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1015, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1016, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true);

INSERT INTO flights (id, instruction_flight, remarks)
VALUES (1017,  true, 'prachtige vlucht');
INSERT INTO flights (id, instruction_flight, remarks)
VALUES (1018,  true, 'harde landing');
