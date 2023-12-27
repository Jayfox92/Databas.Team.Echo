-- Data for players
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('John', 'Doe', 'Johnd', 'johndoe@example.com', '555', '123 Main St', '10001', 'New York', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Alice', 'Smith', 'Alices', 'alicesmith@example.com', '555', '456 Elm St', '20002', 'Washington', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Bob', 'Johnson', 'Bobj', 'bobjohnson@example.com', '555', '789 Oak St', '30003', 'Atlanta', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Emily', 'Brown', 'Emilyb', 'emilybrown@example.com', '555', '101 Pine St', '40004', 'Chicago', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('David', 'Wilson', 'Davidw', 'davidwilson@example.com', '555', '202 Maple St', '50005', 'Los Angeles', 'USA');

-- inserting personnel data

INSERT INTO personnel (first_name, last_name, nickname, email) VALUES ('John', 'Doe', 'Johnny', 'john.doe@example.com');

INSERT INTO personnel (first_name, last_name, nickname, email) VALUES ('Alice', 'Smith', 'Alicia', 'alice.smith@example.com');

INSERT INTO personnel (first_name, last_name, nickname, email) VALUES ('Bob', 'Johnson', 'Bobby', 'bob.johnson@example.com');

INSERT INTO personnel (first_name, last_name, nickname, email) VALUES ('Emily', 'Brown', 'Emmy', 'emily.brown@example.com');





-- Inserting games
INSERT INTO game (game_name, players_per_team) VALUES ('CyberPunk Wars', 4);
INSERT INTO game (game_name, players_per_team) VALUES ('Mystical Quest', 5);
INSERT INTO game (game_name, players_per_team) VALUES ('Galactic Battles', 3);
INSERT INTO game (game_name, players_per_team) VALUES ('Oceanic Explorer', 6);
INSERT INTO game (game_name, players_per_team) VALUES ('Desert Survival', 2);



-- Inserting teams
INSERT INTO team (team_name) VALUES ('Team Alpha');
INSERT INTO team (team_name) VALUES ('Team Beta');
INSERT INTO team (team_name) VALUES ('Team Gamma');
INSERT INTO team (team_name) VALUES ('Team Delta');
INSERT INTO team (team_name) VALUES ('Team Epsilon');


-- Assigning Teams to Games

UPDATE team SET game_id = 1 WHERE team_name = 'Team Alpha';
UPDATE team SET game_id = 2 WHERE team_name = 'Team Beta';
UPDATE team SET game_id = 3 WHERE team_name = 'Team Gamma';
UPDATE team SET game_id = 4 WHERE team_name = 'Team Delta';
UPDATE team SET game_id = 5 WHERE team_name = 'Team Epsilon';

