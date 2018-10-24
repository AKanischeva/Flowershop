CREATE TABLE IF NOT EXISTS ITEM (
  id       IDENTITY(1,1),
  orderId  INT,
  flowerId INT,
  amount   INT,
  FOREIGN KEY (orderId) REFERENCES "ORDER" (id),
  FOREIGN KEY (flowerId) REFERENCES FLOWER (id)
);