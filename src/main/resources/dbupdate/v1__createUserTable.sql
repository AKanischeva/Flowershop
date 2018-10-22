CREATE TABLE IF NOT EXISTS  USER (
  id       IDENTITY(1,1)              NOT NULL,
  username VARCHAR(50)           NOT NULL,
  password VARCHAR(50)           NOT NULL,
  fullname VARCHAR(255),
  phone     VARCHAR(50),
  address  TEXT,
  balance  DOUBLE DEFAULT 2000    NOT NULL,
  discount INT DEFAULT 3,
  isadmin  BOOLEAN DEFAULT FALSE NOT NULL
);

