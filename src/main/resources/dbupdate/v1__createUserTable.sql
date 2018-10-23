CREATE TABLE IF NOT EXISTS  USER (
  id       IDENTITY(1,1)              NOT NULL,
  username VARCHAR(50)           NOT NULL,
  password VARCHAR(50)           NOT NULL,
  fullname VARCHAR(255),
  phone     VARCHAR(50),
  address  TEXT,
  balance  DECIMAL(10,2),
  discount INT,
  isadmin  BOOLEAN DEFAULT FALSE NOT NULL
);

