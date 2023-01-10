USE autohelp;

DROP TABLE client;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE autohelp.client(
	id int NOT NULL AUTO_INCREMENT,
	full_name varchar(150),
    contact varchar(150),
	role varchar(150),
    password varchar(150),
    PRIMARY KEY (id)
);

INSERT INTO autohelp.client VALUES(1, 'Vasya', '88005553535', 'user', '123');