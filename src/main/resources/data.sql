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
VALUES (2006, 'Winch', 1, 5);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (2007, 'Tow', 'minute', 0.2);
INSERT INTO starting_methodes (id, title, unit, price)
VALUES (2008, 'Selfstarter', 0, 0);


INSERT INTO persons ( id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number,

                     postalcode, city, country,
                     email, membership, password, pilot_license, role, user_name)
VALUES ( 3001, 'm', 'Jeffrey', 'Johnson', '0612306345', '1994-08-19', 'straat', '3', '4817SX', 'Amsterdam',
        'Nederland', 'sdbe@novi.nl', 4009, null, null, null, null);
INSERT INTO persons ( id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number,
                     postalcode, city, country, email, membership, password, pilot_license, role, user_name)
VALUES ( 3002, 'v', 'Jan', 'van Westen', '0691256345', '1984-08-19', 'Straatnaam', '993', '4811VC', 'Drenthe',
        'Nederland', 'begin@mailadres.nl', 4010, null, null, null, null);
INSERT INTO persons ( id, gender, first_name, last_name, phone, date_of_birth, street_name, house_number,
                     postalcode, city, country, email, membership, password, pilot_license, role, user_name)
VALUES ( 3003, 'm', 'Tonnie', 'de Vries', '0634506109', '1964-08-19', 'Naamstraat', '55a', '4811VC', 'Rotjeknor',
        'Nederland', 'begin@mailig.nl', 4011, null, null, null, null);


INSERT INTO memberships (id, title, costs_per_month)
VALUES (4009, 'pupil ≤18', 56.00);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4010, 'pupil 18+', 69.00);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4011, 'GPL ≤18', 12.50);
INSERT INTO memberships (id, title, costs_per_month)
VALUES (4012, 'Honourable member', 0.00);

INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (5001, 'G1', 'Alexander Schleicher', 'Ask-13', 'PH-1045', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (5002, 'G7', 'Alexander Schleicher', 'Ask-21', 'PH-1337', true, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (5003, 'G8', 'Rolladen Schneider', 'LS-4', 'PH-740', false, false);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (5004, 'ka8', 'Alexander Schleicher', 'Ka-8b', 'PH-345', false, true);
INSERT INTO planes (id, call_sign, brand, type, registration, two_seater, private_plane)
VALUES (5005, 'EC', 'Rolladen Schleicher', 'LS-6b', 'PH-1203', false, true);


INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6001, true, '', '2022-04-14 13:00:37.185743', '120', '2022-04-14 15:03:07.185743', 5001, 1001, 1001, 2006, 3001,
        3002, 3001);
INSERT INTO flights (id, instruction_flight, remarks, time_end, time_flown, time_start, plane_id, airport_start_id,
                     airport_end_id, starting_methode_id, passenger_id, captain_id, billed_person_id)
VALUES (6002, false, '', '2022-04-14 13:00:37.185743', '6', '2022-04-14 15:03:07.185743', 5002, 1001, 1001, 2006, 3001,
        3003, 3003);



-- INSERT INTO invoices (id, ammount, creation_date, invoice_number, billed_person_id, flights_info_id, type_of_membership_info_id)
-- VALUES (24, 25.00, null, 1, null, 17, 10);