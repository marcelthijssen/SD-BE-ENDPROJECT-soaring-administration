INSERT INTO airports (id, icao, location)
VALUES (1001, 'EHGR', 'Gilze-Rijen');
INSERT INTO airports (id, icao, location)
VALUES (1002, 'EHTE', 'Apeldoorn');
INSERT INTO airports (id, icao, location)
VALUES (1003, 'EHAL', 'Ameland');
INSERT INTO airports (id, icao, location)
VALUES (1004, 'EHAM', 'Haarlemermeer');
INSERT INTO airports (id, icao, location)
VALUES (1005, 'EHTE', 'Lutjebroek');

INSERT INTO starting_methodes (id, title, unit, price)
VALUES (1006, 'Winch', 1, 5);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (1007, 'Tow', 'minute', 0.2);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (1008, 'Selfstarter', 0, 0);

-- INSERT INTO persons (dtype, id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2001, 'm', 'Jeffrey', 'Johnson', '1994-08-19', 'straat', '3', '4817SX', 'Amsterdam', 'Nederland', 'sdbe@novi.nl',
--         '0612306345');
-- INSERT INTO persons (dtype, id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2002, 'v', 'Johan', 'van oosten', '1984-08-19', 'Straatnaam', '993', '4811VC', 'Drenthe', 'Nederland',
--         'begin@mailadres.nl', '0691256345');
-- INSERT INTO persons (dtype, id, gender, first_name, last_name, birthday, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2003, 'm', 'Tonnie', 'de Vries', '1964-08-19', 'Naamstraat', '55a', '4811VC', 'Rotjeknor', 'Nederland',
--         'begin@mailig.nl', '0634506109');

INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (1009, 'pupil ≤18', 56.00);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (1010, 'pupil 18+', 69.00);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (1012, 'GPL ≤18', 12.50);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (1013, 'Honourable member', 0.00);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (1013, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (1014, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (1015, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (1016, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true);

INSERT INTO flights (id, instruction_flight, remarks)
VALUES (1017, true, 'prachtige vlucht');
INSERT INTO flights (id, instruction_flight, remarks)
VALUES (1018, true, 'harde landing');
-- INSERT INTO flights (id, time_start, time_end, instruction_flight, remarks, plane, airport_start, airport_end,
--                      starting_methode, passenger, captain)
-- VALUES (1019, '2022-04-14 13:00:37.185743', '2022-04-14 15:03:07.185743', true, '', 1013, 1001, 1002, 1006, 2003, 2003);
