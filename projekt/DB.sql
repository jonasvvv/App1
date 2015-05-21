
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
Prod1 int NOT NULL DEFAULT 0,
Prod2 int NOT NULL DEFAULT 0,
Prod3 int NOT NULL DEFAULT 0,
Primary key (OID),
FOREIGN KEY (CName) REFERENCES Customer(CName));


Create table ShoppingCart
(CName varchar(20) NOT NULL,
Prod1 int NOT NULL DEFAULT 0,
Prod2 int NOT NULL DEFAULT 0,
Prod3 int NOT NULL DEFAULT 0,
Primary key (CName),
FOREIGN KEY (CName) REFERENCES Customer(CName));

INSERT INTO Customer Values ('Jonas', 'Gatan 1, 75324 Uppsala', 'Jonas', 'Viklund' );
INSERT INTO Products Values ('En bok', 100);
INSERT INTO Products Values ('Två bok', 150);
INSERT INTO Products Values ('Tre bok', 200);
INSERT INTO Products Values ('Anna Book', 200);