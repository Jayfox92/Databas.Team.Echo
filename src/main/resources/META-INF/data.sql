INSERT INTO game (game_name, players_per_team) VALUES ('League of Legends', 5);
INSERT INTO game (game_name, players_per_team) VALUES ('Starcraft 2', 1);
INSERT INTO game (game_name, players_per_team) VALUES ('Counter-Strike: Global Offensive', 5);
INSERT INTO game (game_name, players_per_team) VALUES ('Valorant', 5);
INSERT INTO game (game_name, players_per_team) VALUES ('Rocket League', 5);

INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES (NULL, '2024-01-04', 'upcoming', NULL, NULL);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES (NULL, '2024-01-05', 'upcoming', NULL, NULL);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES (NULL, '2024-01-06', 'upcoming', NULL, NULL);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES (NULL, '2024-01-07', 'upcoming', NULL, NULL);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES (NULL, '2024-01-08', 'upcoming', NULL, NULL);

INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES ('2-1', '2023-12-17', 'concluded', NULL, 2);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES ('0-3', '2023-12-18', 'concluded', NULL, 1);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES ('1-1', '2023-12-19', 'concluded', NULL, 2);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES ('4-0', '2023-12-20', 'concluded', NULL, 2);
INSERT INTO matches (result, match_date, match_status, winner_player_id, winner_team_id) VALUES ('3-2', '2023-12-21', 'concluded', NULL, 2);



INSERT INTO Personnel (first_name, last_name, nickname, email) VALUES ('Richard', 'Hendricks', 'Pied Piper', 'richard.hendricks@piedpiper.com');
INSERT INTO Personnel (first_name, last_name, nickname, email) VALUES ('Erlich', 'Bachman', 'Aviato', 'erlich.bachman@aviato.com');
INSERT INTO Personnel (first_name, last_name, nickname, email) VALUES ('Bertram', 'Gilfoyle', 'Satanist', 'bertram.gilfoyle@piedpiper.com');
INSERT INTO Personnel (first_name, last_name, nickname, email) VALUES ('Dinesh', 'Chugtai', 'Java', 'dinesh.chugtai@piedpiper.com');


INSERT INTO Team (team_name) VALUES ('Team Alpha');
INSERT INTO Team (team_name) VALUES ('Team Beta');
INSERT INTO Team (team_name) VALUES ('Team Gamma');
INSERT INTO Team (team_name) VALUES ('Team Delta');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('John', 'Doe', 'Johnd', 'johndoe@example.com', '555', '123 Main St', '10001', 'New York', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Alice', 'Smith', 'Alices', 'alicesmith@example.com', '555', '456 Elm St', '20002', 'Washington', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Bob', 'Johnson', 'Bobj', 'bobjohnson@example.com', '555', '789 Oak St', '30003', 'Atlanta', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Emily', 'Brown', 'Emilyb', 'emilybrown@example.com', '555', '101 Pine St', '40004', 'Chicago', 'USA');
INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('David', 'Wilson', 'Davidw', 'davidwilson@example.com', '555', '202 Maple St', '50005', 'Los Angeles', 'USA');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Liam', 'O''Brien', 'IrishLiam', 'liamob@example.com', '111', '42 Castle St', 'D02', 'Dublin', 'Ireland');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Emilie', 'Dupont', 'FrenchEm', 'emiliedp@example.fr', '222', '58 Rue de Rivoli', '75004', 'Paris', 'France');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Carlos', 'Garcia', 'CarlosG', 'carlosg@example.es', '333', 'Calle Mayor', '28013', 'Madrid', 'Spain');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Sophia', 'Bianchi', 'ItaliaSoph', 'sophiab@example.it', '444', 'Via Condotti', '00187', 'Rome', 'Italy');

INSERT INTO player(first_name, last_name, nickname, email, phonenumber, street_adress, postal_code, city, country) VALUES ('Lukas', 'Müller', 'GermanLuk', 'lukasm@example.de', '555', 'Kurfürstendamm', '10719', 'Berlin', 'Germany');





-- INSERT INTO manytomany_matches_player (matches_id, player_id) VALUES (1, 1);
-- INSERT INTO manytomany_matches_player (matches_id, player_id) VALUES (1, 2);

-- INSERT INTO manytomany_matches_player (matches_id, player_id) VALUES (2, 3);
-- INSERT INTO manytomany_matches_player (matches_id, player_id) VALUES (2, 4);

-- Linking each match with multiple teams
-- INSERT INTO manytomany_matches_team (matches_id, team_id) VALUES (1, 1);
-- INSERT INTO manytomany_matches_team (matches_id, team_id) VALUES (1, 2);
-- ... Repeating this pattern for matches 1 through 10, linking each to two teams ...
-- For example:
-- INSERT INTO manytomany_matches_team (matches_id, team_id) VALUES (2, 2);
-- INSERT INTO manytomany_matches_team (matches_id, team_id) VALUES (2, 3);
-- Continue this pattern up to match_id = 10 and team_id = 5

-- Linking each player with multiple games
-- INSERT INTO manytomany_player_game (player_id, game_id) VALUES (1, 1);
-- INSERT INTO manytomany_player_game (player_id, game_id) VALUES (1, 2);
-- ... Repeating this pattern for players 1 through 10, linking each to two games ...
-- For example:
-- INSERT INTO manytomany_player_game (player_id, game_id) VALUES (2, 2);
-- INSERT INTO manytomany_player_game (player_id, game_id) VALUES (2, 3);
-- Continue this pattern up to player_id = 10 and game_id = 5


-- INSERT INTO manytomany_team_game (team_id, game_id) VALUES (1, 1);
-- INSERT INTO manytomany_team_game (team_id, game_id) VALUES (1, 2);

-- INSERT INTO manytomany_team_game (team_id, game_id) VALUES (2, 2);
-- INSERT INTO manytomany_team_game (team_id, game_id) VALUES (2, 3);


--UPDATE player SET team_id = 1 WHERE id BETWEEN 1 AND 5;
--UPDATE player SET team_id = 2 WHERE id BETWEEN 6 AND 7;
--UPDATE player SET team_id = 3 WHERE id BETWEEN 8 AND 9;
UPDATE player SET team_id_in_players = 2 WHERE player_id = 1;
UPDATE player SET team_id_in_players = 2 WHERE player_id = 2;
UPDATE player SET team_id_in_players = 2 WHERE player_id = 3;
UPDATE player SET team_id_in_players = 2 WHERE player_id = 4;
UPDATE player SET team_id_in_players = 1 WHERE player_id = 5;
UPDATE player SET team_id_in_players = 1 WHERE player_id = 6;
UPDATE player SET team_id_in_players = 1 WHERE player_id = 7;


