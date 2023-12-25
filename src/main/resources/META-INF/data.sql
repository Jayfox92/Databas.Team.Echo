INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('John', 'Doe', 'Johnd', 'johndoe@example.com', '555', '123 Main St', '10001', 'New York', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Alice', 'Smith', 'Alices', 'alicesmith@example.com', '555', '456 Elm St', '20002', 'Washington', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Bob', 'Johnson', 'Bobj', 'bobjohnson@example.com', '555', '789 Oak St', '30003', 'Atlanta', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Emily', 'Brown', 'Emilyb', 'emilybrown@example.com', '555', '101 Pine St', '40004', 'Chicago', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('David', 'Wilson', 'Davidw', 'davidwilson@example.com', '555', '202 Maple St', '50005', 'Los Angeles', 'USA');

--Data för matches //Fahri
INSERT INTO matches (result, match_date, match_status, winner_id) VALUES ('LOSS', '2023-12-07', 'Completed', 1);
INSERT INTO matches (result, match_date, match_status, winner_id) VALUES ('WIN', '2023-11-17', 'InProgress', 2);
INSERT INTO matches (result, match_date, match_status, winner_id) VALUES ('LOSS', '2023-10-13', 'Completed', 3);
INSERT INTO matches (result, match_date, match_status, winner_id) VALUES ('WIN', '2023-09-23', 'InProgress', 4);
INSERT INTO matches (result, match_date, match_status, winner_id) VALUES ('WIN', '2023-08-29', 'InProgress', 5);

INSERT INTO game (game_name, players_per_team) VALUES ('CyberPunk Wars', 4);
INSERT INTO game (game_name, players_per_team) VALUES ('Mystical Quest', 5);
INSERT INTO game (game_name, players_per_team) VALUES ('Galactic Battles', 3);
INSERT INTO game (game_name, players_per_team) VALUES ('Oceanic Explorer', 6);
INSERT INTO game (game_name, players_per_team) VALUES ('Desert Survival', 2);

--Data for Teams //Abenezer
INSERT INTO team (team_name) VALUES ('Team Alpha');
INSERT INTO team (team_name) VALUES ('Team Beta');
INSERT INTO team (team_name) VALUES ('Team Gamma');
INSERT INTO team (team_name) VALUES ('Team Delta');
INSERT INTO team (team_name) VALUES ('Team Epsilon');