DROP TABLE IF EXISTS IntakeEvents;
DROP TABLE IF EXISTS Drinks;
DROP TABLE IF EXISTS Foods;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    userID INT PRIMARY KEY NOT NULL
);

CREATE TABLE Foods (
    loggedBy INT NOT NULL
  , description TEXT NOT NULL
  , amount TEXT NOT NULL
  , FOREIGN KEY (loggedBy) REFERENCES Users(userID)
);

CREATE TABLE Drinks (
    loggedBy INT NOT NULL
  , description TEXT NOT NULL
  , amount TEXT NOT NULL
  , FOREIGN KEY (loggedBy) REFERENCES Users(userID)
);

CREATE TABLE IntakeEvents (
    loggedBy INT NOT NULL
  , mealType TEXT NOT NULL
  , loggedAt TEXT NOT NULL
  , FOREIGN KEY (loggedBy) REFERENCES Users(userID)
);