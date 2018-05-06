-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-03-27 00:46:50.317

-- tables
-- Table: Coordinate
CREATE TABLE Coordinate (
    id int NOT NULL AUTO_INCREMENT,
    latitude double NOT NULL,
    longitude double NOT NULL,
    Zone_id int NULL,
    CONSTRAINT Coordinate_pk PRIMARY KEY (id)
);

-- Table: FavoriteZone
CREATE TABLE FavoriteZone (
    User_id int NOT NULL,
    Zone_id int NOT NULL,
    CONSTRAINT FavoriteZone_pk PRIMARY KEY (User_id,Zone_id)
);

-- Table: Publication
CREATE TABLE Publication (
    id int NOT NULL AUTO_INCREMENT,
    CONSTRAINT Publication_pk PRIMARY KEY (id)
);

-- Table: Report
CREATE TABLE Report (
    id int NOT NULL AUTO_INCREMENT,
    datereport datetime NOT NULL,
    img varchar(50) NULL,
    comment varchar(50) NULL,
    weather char(20) NOT NULL,
    User_id int NOT NULL,
    Zone_id int NOT NULL,
    Coordinate_id int NOT NULL,
    Publication_id int NULL,
    CONSTRAINT Report_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE Users (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(20) NOT NULL,
    name varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    img varchar(100) NOT NULL,
    confpasswd varchar(20) NOT NULL,
    CONSTRAINT User_pk PRIMARY KEY (id)
);

-- Table: Zone
CREATE TABLE Zones (
    id int NOT NULL AUTO_INCREMENT,
    number int NOT NULL,
    name char(100) NOT NULL,
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

-- Reference: Report_Coordinate (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_Coordinate FOREIGN KEY Report_Coordinate (Coordinate_id)
    REFERENCES Coordinate (id);

-- Reference: Report_Publication (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_Publication FOREIGN KEY Report_Publication (Publication_id)
    REFERENCES Publication (id);

-- Reference: Report_User (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_User FOREIGN KEY Report_User (User_id)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: Report_Zone (table: Report)
ALTER TABLE Report ADD CONSTRAINT Report_Zone FOREIGN KEY Report_Zone (Zone_id)
    REFERENCES Zones (id);

-- End of file.

