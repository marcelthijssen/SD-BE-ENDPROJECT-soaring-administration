INSERT INTO airports (id, icao, city, country)
VALUES (1001, 'EHGR', 'Gilze-Rijen', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1002, 'EHTE', 'Apeldoorn', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1003, 'EHAL', 'Ameland', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1004, 'EHAM', 'Haarlemermeer', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1005, 'EHEH', 'Eindhoven', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1006, 'EHTL', 'arnhem', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1007, 'EHLE', 'Lelystad', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1008, 'EHSB', 'Soesterbeg', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1009, 'EHWO', 'Woensdrecht', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (1010, 'EDLG', 'Asperden', 'Duitsland');

INSERT INTO starting_methodes (id, title, unit, price)
VALUES (2001, 'Winch', 1, 5);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (2002, 'Tow', 'minute', 0.2);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (2003, 'Selfstarter', 0, 0);

INSERT INTO memberships (id, title, costs_per_month)
VALUES (4001, 'pupil ≤18', 56.00);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4002, 'pupil 18+', 69.00);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4003, 'GPL ≤18', 12.50);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4004, 'Honourable member', 0.00);

INSERT INTO users (username, password, email, enabled)
VALUES ('user', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'user@test.nl', false);
INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'admin@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user2', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'test2@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user3', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'test3@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user4', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'test4@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user5', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'test5@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user6', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'test6@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('willie', '$2a$10$ixD3Fpf0tw9/ZSj0hpO2g.Z4J4NobFgHfuZTSmLHjXSY5Nz/sOmMy', 'willie@wortel.nl', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_TECHNICIAN');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('willie', 'ROLE_TECHNICIAN');
INSERT INTO authorities (username, authority)
VALUES ('user3', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user4', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user5', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user6', 'ROLE_USER');

INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3001, 'MALE', 'Jeffrey', 'Johnson', '0612345678', '1994-08-19',  'sdbe@novi.nl', false, 4001);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3002, 'OTHER', 'Jan', 'van Westen', '0612345678', '1984-08-19',  'begins@mailadres.nl', false, 4002);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3003, 'FEMALE', 'Fem', 'achternaam', '0612345678', '1974-08-19', 'fem@mailings.nl', true, 4003);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3004, 'MALE', 'Casper', 'Anders', '0612345678', '1984-08-19',  'begin@mailig.nl', true, 4004);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3005, 'FEMALE', 'Nicole', 'Adriaansen', '0612345678', '1994-01-01', 'Tonnie@mailig.nl', null, 4003);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3006, 'MALE', 'jan', 'Pietersen', '0612345678', '2004-01-01', 'begfin@mailig.nl', true, 4003);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3007, 'FEMALE', 'Johan', 'de Beek', '0612345678', '2008-12-01', 'begffin@mailig.nl', true, 4003);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3008, 'MALE', 'Wilie', 'Wortel', '0612345678', '2008-12-01', 'willie@wortel.nl', false, 4003);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, email, pilot_license, membership_id)
VALUES (3009, 'MALE', 'Wilie', 'Wortel', '0612345678', '2008-12-01', 'willfie@wortel.nl', false, 4003);

INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3001, 'Breda', 'Nederland', 12, '4811AA', 'Hobokenstraat', '3001');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3002, 'Tilburg', 'Nederland', 23, '4813AS', 'Straatnaam', '3002');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3003, 'Goirle', 'Nederland', 56, '4811LK', 'Oude straatnaam','3003');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3004, 'Goirle', 'Nederland', 56, '4811LK', 'Oude straatnaam','3004');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3005, 'Houten', 'Nederland', 34, '4811BB', 'Anderestraat', '3005');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3006, 'Rotterdam', 'Nederland', 45, '4811XW', 'Diestraat','3006');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3007, 'Goirle', 'Nederland', 56, '4811LK', 'Oude straatnaam','3007');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3008, 'Goirle', 'Nederland', 56, '4811LK', 'Oude straatnaam','3008');
INSERT INTO ADDRESSES ( id, city, country, house_number, postalcode, street_name, person_id)
VALUES ( 3009, 'Goirle', 'Nederland', 56, '4811LK', 'Oude straatnaam','3009');

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5001, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false, 3001, 3001, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5002, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, true, 3002, 3002, null, 0.1);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5003, 'G4', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false, 3002, 3003, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5004, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true, 3003, 3002, null, 0);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5005, 'EC', 'Rolladen Schleicher', 'LS-6b', 'PH-1203', false, true, 3003, 3001, null, 0);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5006, 'k8c', 'Alexander Schleicher', 'Rhone', 'PH-152', false, true, 3003, 3001, null, 0);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5007, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-742', false, false, 3002, 3003, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5008, 'G9', 'Grob', '2b', 'PH-1254', false, true, 3007, 3007, null, 0);


INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6001, 'INSTRUCTION_FLIGHT', '', '2022-04-14 10:00:37.185743', '18', '2022-04-14 15:03:07.185743', 5001, 1001, 1001, 2001, 3001,
        3006, 3001);
INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6002, 'INSTRUCTION_FLIGHT', '', '2022-04-14 10:00:37.185743', '8', '2022-04-14 15:03:07.185743', 5002, 1001, 1001, 2001, 3001,
        3007, 3003);
INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6003, 'INSTRUCTION_FLIGHT', '', '2022-04-14 10:00:37.185743', '12', '2022-04-14 15:03:07.185743', 5001, 1001, 1001, 2001, 3001,
        3002, 3001);
INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6004, 'INSTRUCTION_FLIGHT', '', '2022-04-14 10:00:37.185743', '6', '2022-04-14 15:03:07.185743', 5002, 1001, 1001, 2001, 3001,
        3004, 3001);
INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6005, 'INSTRUCTION_FLIGHT', '', '2022-04-14 10:00:37.185743', '111', '2022-04-14 15:03:07.185743', 5001, 1001, 1002, 2001, 3001,
        3002, 3001);
INSERT INTO flights (id, flight_type, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6006, 'PRIVATE_FLIGHT', 'opmerking', '2022-04-14 10:00:37.185743', '6', '2022-04-14 15:03:07.185743', 5002, 1001, 1001, 2001, 3001,
        3004, 3003);

INSERT INTO invoices (invoice_number, amount, creation_date, billed_person_id, flight_id)
VALUES (6001, 5, '2022-04-14', 3001, 6001);
INSERT INTO invoices (invoice_number, amount, creation_date, billed_person_id, flight_id)
VALUES (6002, 7, '2022-04-15', 3003, 6002);
INSERT INTO invoices (invoice_number, amount, creation_date, billed_person_id, flight_id)
VALUES (6003, 11, '2022-04-16', 3001, 6003);
INSERT INTO invoices (invoice_number, amount, creation_date, billed_person_id, flight_id)
VALUES (6004, 4, '2022-04-17', 3004, 6004);
