# group17
COMP2411
SQL statements:
1. User Account Management:
- CREATE TABLE Users ( UserID INT AUTO_INCREMENT, Username VARCHAR(255) NOT NULL, Password VARCHAR(255) NOT NULL, Email VARCHAR(255) NOT NULL, FirstName VARCHAR(255), LastName VARCHAR(255), PRIMARY KEY (UserID) );

INSERT INTO Users (Username, Password, Email, FirstName, LastName) VALUES ('user1', 'password1', 'user1@email.com', 'John', 'Doe');

CREATE TABLE ShippingAddresses ( AddressID INT AUTO_INCREMENT, UserID INT, StreetAddress VARCHAR(255), City VARCHAR(255), State VARCHAR(255), ZipCode VARCHAR(255), Country VARCHAR(255), PRIMARY KEY (AddressID), FOREIGN KEY (UserID) REFERENCES Users(UserID) );

2. Product Listings and Search:
CREATE TABLE Categories ( CategoryID INT AUTO_INCREMENT, CategoryName VARCHAR(255) NOT NULL, PRIMARY KEY (CategoryID) );

CREATE TABLE Products ( ProductID INT AUTO_INCREMENT, ProductName VARCHAR(255) NOT NULL, ProductDescription TEXT, ProductPrice DECIMAL(10, 2) NOT NULL, CategoryID INT, PRIMARY KEY (ProductID), FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) );

3. Shopping Cart and Checkout:
CREATE TABLE ShoppingCart ( CartID INT AUTO_INCREMENT, UserID INT, ProductID INT, Quantity INT, PRIMARY KEY (CartID), FOREIGN KEY (UserID) REFERENCES Users(UserID), FOREIGN KEY (ProductID) REFERENCES Products(ProductID) );

CREATE TABLE Orders ( OrderID INT AUTO_INCREMENT, UserID INT, ShippingAddressID INT, OrderDate DATE, OrderStatus VARCHAR(255), PRIMARY KEY (OrderID), FOREIGN KEY (UserID) REFERENCES Users(UserID), FOREIGN KEY (ShippingAddressID) REFERENCES ShippingAddresses(AddressID) );

CREATE TABLE OrderDetails ( OrderDetailID INT AUTO_INCREMENT, OrderID INT, ProductID INT, Quantity INT, PRIMARY KEY (OrderDetailID), FOREIGN KEY (OrderID) REFERENCES Orders(OrderID), FOREIGN KEY (ProductID) REFERENCES Products(ProductID) );

4. Inventory Management:
No additional tables are required, as the existing tables provide enough information for managing the inventory.

5. Reporting and Analytics:
CREATE VIEW TotalSales AS SELECT ProductID, SUM(Quantity) AS TotalQuantity FROM OrderDetails GROUP BY ProductID;

CREATE VIEW CategorySales AS SELECT C.CategoryName, SUM(OD.TotalQuantity) AS TotalQuantity FROM Categories C JOIN Products P ON C.CategoryID = P.CategoryID JOIN TotalSales TS ON P.ProductID = TS.ProductID GROUP BY C.CategoryName;

SELECT * FROM CategorySales;

Note: These are simplified examples, and you would need to consider factors such as password security, product images, multiple shipping addresses per user, and transaction handling. Additionally, the specific implementation would depend on the programming language and framework used for the database application. 
