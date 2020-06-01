DROP TABLE IF EXISTS Signs;

CREATE TABLE Signs(
  ID serial primary key ,
  Name varchar(30) NOT NULL,
  Date DATE NOT NULL,
  Time TIME NOT NULL,
  Message VARCHAR(3000) NOT NULL
);