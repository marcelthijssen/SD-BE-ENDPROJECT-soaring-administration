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
VALUES ('user', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'user@test.nl', false);
INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'admin@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user2', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'test@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user3', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'test@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user4', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'test@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user5', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'test@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('user6', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'test@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('willie', '$2a$10$Gi81J40Smh7Di//HeQAZEOt4/JskZFZemxSJ7E7RAvCWDY0v248yK', 'willie@wortel.nl', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user3', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user4', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user5', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('user6', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('willie', 'ROLE_TECHNICIAN');


INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number, postalcode,
                     city, country, email, pilot_license, membership_id)
VALUES (3001, 'm', 'Jeffrey', 'Johnson', '0612306345', '1994-08-19', 'straat', '3', '4817SX', 'Amsterdam', 'Nederland',
        'sdbe@novi.nl', null, 4001);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number, postalcode,
                     city, country, email, pilot_license, membership_id)
VALUES (3002, 'v', 'Jan', 'van Westen', '0691256345', '1984-08-19', 'Straatnaam', '993', '4811VC', 'Drenthe',
        'Nederland', 'begin@mailadres.nl', null, 4002);
INSERT INTO persons (id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number,
                     postalcode, city, country, email, pilot_license, membership_id)
VALUES (3003, 'v', 'Fem', 'achternaam', '0634506109', '1974-08-19', 'Naamstrasse', '12', '4621VC', 'Ergensanders',
        'Nederland', 'fem@mailings.nl', null, 4003);
VALUES (3004, 'm', 'Casper', 'Anders', '0634506109', '1984-08-19', 'Straatnaam', '2', '4811VC', 'Rotjeknor',
        'Nederland', 'begin@mailig.nl', null, 4004);
VALUES (3005, 'v', 'Nicole', 'Adriaansen', '0634506109', '1994-01-01', 'Naafdmstraat', '65', '4811VC', 'Tilburg',
        'Nederland', 'Tonnie@mailig.nl', null, 4003);
VALUES (3006, 'm', 'jan', 'Pietersen', '0634506109', '2004-01-01', 'Naamstjhgfraat', '12', '4811VC', 'Volendam',
        'Nederland', 'begin@mailig.nl', null, 4003);
VALUES (3007, 'v', 'Johan', 'de Beek', '0634506109', '2008-12-01', 'Naamsdtyhfgjfghtraat', '15', '4811VC', 'Breda',
        'Nederland', 'begin@mailig.nl', null, 4003);
VALUES (3007, 'm', 'Wilie', 'Wortel', '0634506109', '2008-12-01', 'Naamsdtyhfgjfghtraat', '15', '4811VC', 'Breda',
        'Nederland', 'willie@wortel.nl', null, 4003);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5001, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false, 3001, 3001, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5002, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, true, 3002, 3002, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5003, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false, 3002, 3003, null, 0.25);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5004, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true, 3003, 3002, null, 0);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane, owner_id, technician_id,
                    flight_status, minute_price)
VALUES (5005, 'EC', 'Rolladen Schleicher', 'LS-6b', 'PH-1203', false, true, 3003, 3001, null, 0);

INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6001, true, '', '2022-04-14 10:00:37.185743', '120', '2022-04-14 15:03:07.185743', 5001, 1001, null, 2001, 3001,
        3002, 3001);
INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6002, false, '', '2022-04-14 10:00:37.185743', '6', '2022-04-14 15:03:07.185743', 5002, 1001, null, 2001, 3001,
        3003, 3003);