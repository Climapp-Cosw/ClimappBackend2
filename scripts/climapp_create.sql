-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-03-27 00:46:50.317

-- tables
-- Table: Coordinate
CREATE TABLE Coordinate (
    id int NOT NULL AUTO_INCREMENT,
    latitude double NOT NULL,
    longitude double NOT NULL,
    Zone_id int NOT NULL,
    CONSTRAINT Coordinate_pk PRIMARY KEY (id)
);

-- Table: FavoriteZone
CREATE TABLE FavoriteZone (
    User_id int NOT NULL,
    Zone_id int NOT NULL,
    CONSTRAINT FavoriteZone_pk PRIMARY KEY (User_id,Zone_id)
);

-- Table: Report
CREATE TABLE Report (
    id int NOT NULL AUTO_INCREMENT,
    datereport datetime NOT NULL,
    weather int NOT NULL,
    User_id int not null,
    Zone_id int NOT NULL,
    latitude double NOT NULL,
    longitude double NOT NULL,
	dislike int NOT NULL,
	likes int NOT NULL,
	rain int NOT NULL,
    CONSTRAINT Report_pk PRIMARY KEY (id)
);
-- Table: Sensor
CREATE TABLE Sensor (
    id int NOT NULL AUTO_INCREMENT,
    temperature float NOT NULL,
    pollution float NOT NULL,
    humidity float NOT NULL,
    Zone_id int NOT NULL,
    latitude double NOT NULL,
    longitude double NOT NULL,
	rain boolean NOT NULL,
    CONSTRAINT Sensor_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE Users (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    name varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    img varchar(100) NOT NULL,
	points int NOT NULL,
    CONSTRAINT User_pk PRIMARY KEY (id)
);

-- Table: Zone
CREATE TABLE Zones (
    id int NOT NULL AUTO_INCREMENT,
    number int NOT NULL,
    name varchar(100) NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Coordinate_Zone (table: Coordinate)
ALTER TABLE Coordinate ADD CONSTRAINT Coordinate_Zone FOREIGN KEY Coordinate_Zone (Zone_id)
    REFERENCES Zones (id);

-- Reference: FavoriteZone_User (table: FavoriteZone)
ALTER TABLE FavoriteZone ADD CONSTRAINT FavoriteZone_User FOREIGN KEY FavoriteZone_User (User_id)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: FavoriteZone_Zone (table: FavoriteZone)
ALTER TABLE FavoriteZone ADD CONSTRAINT FavoriteZone_Zone FOREIGN KEY FavoriteZone_Zone (Zone_id)
    REFERENCES Zones (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: Report_User (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_User FOREIGN KEY Report_User (User_id)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: Report_Zone (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_Zone FOREIGN KEY Report_Zone (Zone_id)
    REFERENCES Zones (id);

-- Reference: Sensor_Zone (table: Sensor)
ALTER TABLE Sensor ADD CONSTRAINT Sensor_Zone FOREIGN KEY Sensor_Zone (Zone_id)
    REFERENCES Zones (id);

-- End of file.

