INSERT INTO airports (id, icao, city, country)
VALUES (1, 'EHGR', 'Gilze-Rijen', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (2, 'EHTE', 'Apeldoorn', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (3, 'EHAL', 'Ameland', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (4, 'EHAM', 'Haarlemermeer', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (5, 'EHEH', 'Eindhoven', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (19, 'EHTL', 'arnhem', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (20, 'EHLE', 'Lelystad', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (21, 'EHSB', 'Soesterbeg', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (22, 'EHWO', 'Woensdrecht', 'Nederland');
INSERT INTO airports (id, icao, city, country)
VALUES (23, 'EDLG', 'Asperden', 'Duitsland');

INSERT INTO starting_methodes (id, title, unit, price)
VALUES (6, 'Winch', 1, 5);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (7, 'Tow', 'minute', 0.2);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (8, 'Selfstarter', 0, 0);

-- INSERT INTO persons (dtype, id, gender, first_name, last_name, date_of_birth, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2001, 'm', 'Jeffrey', 'Johnson', '1994-08-19', 'straat', '3', '4817SX', 'Amsterdam', 'Nederland', 'sdbe@novi.nl',
--         '0612306345');
-- INSERT INTO persons (dtype, id, gender, first_name, last_name, date_of_birth, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2002, 'v', 'Johan', 'van oosten', '1984-08-19', 'Straatnaam', '993', '4811VC', 'Drenthe', 'Nederland',
--         'begin@mailadres.nl', '0691256345');
-- INSERT INTO persons (dtype, id, gender, first_name, last_name, date_of_birth, street_name, house_number, postalcode, city, country,
--                      email, phone)
-- VALUES (Person, 2003, 'm', 'Tonnie', 'de Vries', '1964-08-19', 'Naamstraat', '55a', '4811VC', 'Rotjeknor', 'Nederland',
--         'begin@mailig.nl', '0634506109');

INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (9, 'pupil ≤18', 56.00);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (10, 'pupil 18+', 69.00);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (11, 'GPL ≤18', 12.50);
INSERT INTO type_of_memberships (id, title, costs_per_month)
VALUES (12, 'Honourable member', 0.00);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (13, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (14, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (15, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (16, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true);

INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (17, true, '', '2022-04-14 13:00:37.185743', '0', '2022-04-14 15:03:07.185743', null, null, null, null, null, null, null);
INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (18, false, '', '2022-04-14 13:00:37.185743', '0', '2022-04-14 15:03:07.185743', null, null, null, null, null, null, null);

-- INSERT INTO invoices (id, ammount, creation_date, invoice_number, billed_person_id, flights_info_id, type_of_membership_info_id)
-- VALUES (24, 25.00, null, 1, null, 17, 10);