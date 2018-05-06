-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-03-27 00:46:50.317

-- foreign keys
ALTER TABLE Coordinate
    DROP FOREIGN KEY Coordinate_Zone;

ALTER TABLE FavoriteZone
    DROP FOREIGN KEY FavoriteZone_User;

ALTER TABLE FavoriteZone
    DROP FOREIGN KEY FavoriteZone_Zone;

ALTER TABLE Report
    DROP FOREIGN KEY Report_Coordinate;

ALTER TABLE Report
    DROP FOREIGN KEY Report_Publication;

ALTER TABLE Report
    DROP FOREIGN KEY Report_User;

ALTER TABLE Report
    DROP FOREIGN KEY Report_Zone;

-- tables
DROP TABLE Coordinate;

DROP TABLE FavoriteZone;

DROP TABLE Publication;

DROP TABLE Report;

DROP TABLE Users;

DROP TABLE Zones;

-- End of file.

