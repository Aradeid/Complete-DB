CREATE DATABASE CompleteDB;
USE CompleteDB;

CREATE TABLE Users (
	userid int AUTO_INCREMENT PRIMARY KEY,
    username varchar(30) NOT NULL,
    regionid int
);

CREATE TABLE Stickers (
	stickerid int AUTO_INCREMENT PRIMARY KEY,
    stickername varchar(50) NOT NULL
);

CREATE TABLE UserInventory (
	userid int,
    FOREIGN KEY (userid) REFERENCES Users(userid),
	stickerid int,
    FOREIGN KEY (stickerid) REFERENCES Stickers(stickerid),
	amount int DEFAULT 1 CHECK (amount >= 0),
	PRIMARY KEY (userid, stickerid)
);

CREATE TABLE Offers (
	offerid int AUTO_INCREMENT PRIMARY KEY,
    offeringuser int,
    FOREIGN KEY (offeringuser) REFERENCES Users(userid),
    offeredsticker int,
    FOREIGN KEY (offeredsticker) REFERENCES Stickers(stickerid),
    offeredamount int CHECK (offeredamount >= 0),
    --seekedsticker int, -- removed as not relevant right now
    --FOREIGN KEY (seekedsticker) REFERENCES Stickers(stickerid),
    --seekedamount int CHECK (seekedamount >= 0)
);

CREATE TABLE Regions (
	regionid int AUTO_INCREMENT PRIMARY KEY,
    regionname varchar(20) NOT NULL
);