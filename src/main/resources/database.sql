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

-- Table: bets
CREATE TABLE bets (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  matchId VARCHAR(255) NOT NULL,
  userInitiator VARCHAR(255) NOT NULL,
  priceOfInitiator BIGINT NOT NULL,
  initiatorWinner VARCHAR(255) NOT NULL,
  testMoney BOOLEAN NOT NULL,
  privateBet BOOLEAN NOT NULL,
  invitedUser VARCHAR(255) NOT NULL,
  approved BOOLEAN NOT NULL
)
  ENGINE = InnoDB;


