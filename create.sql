DROP TABLE IF EXISTS Drinks;
DROP TABLE IF EXISTS Foods;
DROP TABLE IF EXISTS IntakeEvents;
DROP TABLE IF EXISTS Users;


CREATE TABLE Users (
    userID INT NOT NULL
);

CREATE TABLE IntakeEvents (
    id INT NOT NULL PRIMARY KEY
  , loggedBy INT NOT NULL
  , mealType TEXT NOT NULL
  , loggedAt TEXT NOT NULL
);

CREATE TABLE Foods (
    eventId INT NOT NULL
  , description TEXT NOT NULL
  , amount TEXT NOT NULL
  , FOREIGN KEY (eventId) REFERENCES IntakeEvents(id)
);

CREATE TABLE Drinks (
    eventID INT NOT NULL
  , description TEXT NOT NULL
  , amount TEXT NOT NULL
  , FOREIGN KEY (eventId) REFERENCES IntakeEvents(id)
);

