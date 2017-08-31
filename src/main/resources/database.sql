-- Table: users
CREATE TABLE matches (
  id       VARCHAR(255)     NOT NULL PRIMARY KEY,
  leftRes INT,
  rightRes INT,
  leftTeam VARCHAR(255) NOT NULL,
  rightTeam VARCHAR(255) NOT NULL,
  finished BOOLEAN NOT NULL,
  date VARCHAR(255) NOT NULL,
  leftPic VARCHAR(255) NOT NULL,
  rightPic VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;


