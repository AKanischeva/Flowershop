CREATE TABLE IF NOT EXISTS ITEM (
  id       IDENTITY(1,1),
  student text,
  theme text,
  director text,
  year1 text,
  faculty text,
  description text,
  upload LONGBLOB,
  filename text
);