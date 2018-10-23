CREATE TABLE IF NOT EXISTS  "ORDER" (
  id           IDENTITY(1,1)           NOT NULL,
  userid       INT             NOT NULL,
  createdate   TIMESTAMP          NOT NULL,
  completedate TIMESTAMP,
  subtotal     DECIMAL            NOT NULL,
  status       ENUM ('NEW',
                     'PAID',
                     'CLOSED') NOT NULL,
  FOREIGN KEY (userid) REFERENCES USER (id)
);
