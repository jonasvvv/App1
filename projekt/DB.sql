drop table ShoppingCart
drop table OrderInfo
drop table Products
drop table Customer


Create table Products
(PName varchar(20) NOT NULL PRIMARY KEY,
 Cost int NOT NULL);


Create table Customer
(CName varchar(20) NOT NULL PRIMARY KEY,
Address varchar(255) NOT NULL,
FirstName varchar(255) NOT NULL,
LastName varchar(255) NOT NULL);


Create table OrderInfo
(CName varchar(20) NOT NULL,
OID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
OTime timestamp default Current_Timestamp,
Sandbag int NOT NULL DEFAULT 0,
Clock int NOT NULL DEFAULT 0,
Hat int NOT NULL DEFAULT 0,
Pizza int NOT NULL DEFAULT 0,
Spaceship int NOT NULL DEFAULT 0,
Primary key (OID),
FOREIGN KEY (CName) REFERENCES Customer(CName));


Create table ShoppingCart
(CName varchar(20) NOT NULL,
Sandbag int NOT NULL DEFAULT 0,
Clock int NOT NULL DEFAULT 0,
Hat int NOT NULL DEFAULT 0,
Pizza int NOT NULL DEFAULT 0,
Spaceship int NOT NULL DEFAULT 0,
Primary key (CName),
FOREIGN KEY (CName) REFERENCES Customer(CName));

INSERT INTO Customer Values ('jonas', 'Gatan 1, 75324 Uppsala', 'Jonas', 'Viklund' );
INSERT INTO Products Values ('Sandbag', 100);
INSERT INTO Products Values ('Clock', 349);
INSERT INTO Products Values ('Hat', 499);
INSERT INTO Products Values ('Pizza', 65);
INSERT INTO Products Values ('Spaceship', 299999999);
INSERT INTO ShoppingCart Values ('jonas',0,0,0,0,0);

INSERT INTO Customer Values ('Alexander', 'Betgatan 21, 75449 Uppsala', 'Alexander', 'Johnson' );
INSERT INTO ShoppingCart Values ('Alexander',0,0,0,0,0);

INSERT INTO Customer Values ('Hans-Erik', 'En Annan gata 2, 75449 Uppsala', 'Hans-Erik', 'Bratt' );
INSERT INTO ShoppingCart Values ('Hans-Erik',0,0,0,0,0);