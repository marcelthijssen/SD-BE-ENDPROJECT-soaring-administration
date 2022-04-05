INSERT INTO airports (id, icao, location) VALUES (1001, 'EHGR', 'Gilze-Rijen');
INSERT INTO airports (id, icao, location) VALUES (1002, 'EHTE', 'Apledoorn');
INSERT INTO airports (id, icao, location) VALUES (1003, 'EHAL', 'Ameland');
INSERT INTO airports (id, icao, location) VALUES (1004, 'EHAM', 'Haarlemermeer');
INSERT INTO airports (id, icao, location) VALUES (1005, 'EHTE', 'Ameland');

INSERT INTO starting_methods (id, title, unit, price) VALUES (1006, 'winch', 1, 5);
INSERT INTO starting_methods (id, title, unit, price) VALUES (1007, 'tow', 'minute', 0.2);
INSERT INTO starting_methods (id, title, unit, price) VALUES (1008,'selfstarter', 0, 0);

INSERT INTO type_of_memberships (id, title, costs_per_month, max) VALUES (1009, 'pupil ≤18', 56, 828);
INSERT INTO type_of_memberships (id, title, costs_per_month, max) VALUES (1010, 'pupil 18+', 69, 828);
INSERT INTO type_of_memberships (id, title, costs_per_month, max) VALUES (1011, 'GPL 18+', 48, 828);
INSERT INTO type_of_memberships (id, title, costs_per_month, max) VALUES (1012, 'GPL ≤18', 12.50, 828);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1013, 'G1', 'Alexaner Schleicher', 'Ask-13', 'PH-1045', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1014, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1015, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane) VALUES (1016, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true);

INSERT INTO flights (id, start_time, end_time, captain, passenger, instruction_flight, remarks)
VALUES (1017, '2022-04-04T11:48:25.82', '2022-04-04T12:58:55.02', 'Patrick Teterroo', 'Marcel Thijssen',
        true, 'prachtige vlucht');
INSERT INTO flights (id, start_time, end_time, captain, passenger, instruction_flight, remarks)
VALUES (1018, '2022-04-04T12:12:25.82', '2022-04-04T12:17:05.02', 'Robbie frishert', 'Femke boersen',
        true, 'harde landing');
