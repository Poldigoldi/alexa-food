DROP TABLE IF EXISTS foodDiary;

CREATE TABLE foodDiary (
  id INTEGER PRIMARY KEY AUTO_INCREMENT
  , userID INT NOT NULL
  , meal TEXT
  , food TEXT
  , drink TEXT
  , amount TEXT
  , loggedAt TIMESTAMP
);
