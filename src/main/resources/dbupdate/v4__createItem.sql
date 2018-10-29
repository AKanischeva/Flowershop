CREATE TABLE IF NOT EXISTS ITEM (
  id       IDENTITY(1,1),
  orderId  INT,
  flowerId INT,
  amount   INT,
  price    DECIMAL(10,2),
  FOREIGN KEY (orderId) REFERENCES "ORDER" (id),
  FOREIGN KEY (flowerId) REFERENCES FLOWER (id)
);