CREATE TABLE game (
	game_id int NOT NULL AUTO_INCREMENT,
    player1 varchar (255),
    player2 varchar (255),
    result1 int,
    result2 int,
    PRIMARY KEY (game_id)
);