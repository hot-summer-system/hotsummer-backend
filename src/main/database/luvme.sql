DROP database if EXISTS LuvMe
GO
CREATE database LuvMe

GO
USE LuvMe;
GO
DROP TABLE if EXISTS Role
DROP TABLE if EXISTS TestHistory
DROP TABLE if EXISTS UserAct
DROP TABLE if EXISTS Favorite
DROP TABLE if EXISTS Routing
DROP TABLE if EXISTS RoutingStep
DROP TABLE if EXISTS Transactions
DROP TABLE if EXISTS Product
DROP TABLE if EXISTS ProductSkinType
DROP TABLE if EXISTS ProductCategory
DROP TABLE if EXISTS ProductCharacteristics
DROP TABLE if EXISTS ProductIngredient
DROP TABLE if EXISTS SuitableSkinType
DROP TABLE if EXISTS Category
DROP TABLE if EXISTS Ingredient
DROP TABLE if EXISTS Question
DROP TABLE if EXISTS Answer
DROP TABLE if EXISTS Result

GO
CREATE TABLE Role(
  role_id INT IDENTITY(1,1),
  role_name VARCHAR(50),
  description nvarchar(300),
  PRIMARY KEY(role_id)
)

GO
CREATE TABLE UserAct(
  user_id INT IDENTITY(1,1),
  role_id INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  full_name nvarchar(100),
  gender nvarchar(30),
  status nvarchar(30),
  birth_day datetime,
  bank_account VARCHAR(100),
  is_premium BIT NOT NULL,
  start_premium_date datetime,
  end_premium_date datetime
  PRIMARY KEY(user_id),
  FOREIGN KEY(role_id) REFERENCES Role(role_id)
)

GO
CREATE TABLE TestHistory(
  history_id INT IDENTITY(1,1),
  user_id INT NOT NULL,
  [date] datetime,
  skin_type nvarchar(100)
  PRIMARY KEY(history_id),
  FOREIGN KEY(user_id) REFERENCES UserAct(user_id)
)

GO
CREATE TABLE Routing(
  routing_id VARCHAR(50) NOT NULL,
  user_id INT NOT NULL,
  routing_type VARCHAR(1),
  [date] datetime,
  description nvarchar(1000),
  is_done BIT
  PRIMARY KEY(routing_id),
  FOREIGN KEY(user_id) REFERENCES UserAct(user_id)
)

GO
CREATE TABLE Transactions(
  transaction_id INT IDENTITY(1,1),
  user_id INT NOT NULL,
  to_bank nvarchar(50),
  transaction_type VARCHAR(50),
  description nvarchar(1000),
  created_at datetime,
  amount DECIMAL NOT NULL DEFAULT 0
  PRIMARY KEY(transaction_id),
  FOREIGN KEY(user_id) REFERENCES UserAct(user_id)
)

GO
CREATE TABLE RoutingStep(
  routing_step_id INT IDENTITY(1,1),
  routing_id VARCHAR(50) NOT NULL,
  product_id VARCHAR(50) NOT NULL,
  description nvarchar(1000)
  PRIMARY KEY(routing_step_id)
)

GO
CREATE TABLE Product(
  product_id VARCHAR(50) NOT NULL,
  product_name nvarchar(100),
  product_image nvarchar(MAX),
  description nvarchar(1000)
  PRIMARY KEY(product_id)
)

GO
CREATE TABLE Favorite(
  favorite_id INT IDENTITY(1,1),
  product_id nvarchar(300),
  add_date datetime
)

GO
CREATE TABLE SuitableSkinType(
  type_id INT IDENTITY(1,1),
  description nvarchar(1000),
  PRIMARY KEY(type_id)
)

GO
CREATE TABLE Category(
  category_id INT IDENTITY(1,1),
  category_name nvarchar(100),
  description nvarchar(1000),
  image nvarchar(MAX),
  PRIMARY KEY(category_id)
)

GO
CREATE TABLE Ingredient(
  ingredient_id INT IDENTITY(1,1),
  name nvarchar(100),
  description nvarchar(1000),
  PRIMARY KEY(ingredient_id)
)

GO
CREATE TABLE ProductSkinType(
  product_skin_type_id INT IDENTITY(1,1),
  product_id VARCHAR(50) NOT NULL,
  type_id INT IDENTITY(1,1),
  description nvarchar(1000),
  PRIMARY KEY(product_skin_type_id),
  FOREIGN KEY(product_id) REFERENCES Product(product_id),
  FOREIGN KEY(type_id) REFERENCES SuitableSkinType(type_id)
)

GO
CREATE TABLE ProductCategory(
  product_category_id INT IDENTITY(1,1),
  category_id INT IDENTITY(1,1),
  product_id VARCHAR(50) NOT NULL,
  description nvarchar(1000),
  PRIMARY KEY(product_category_id),
  FOREIGN KEY(product_id) REFERENCES Product(product_id),
  FOREIGN KEY(category_id) REFERENCES Category(category_id)
)

GO
CREATE TABLE ProductCharacteristics(
  characteristics_id INT IDENTITY(1,1),
  product_id VARCHAR(50) NOT NULL,
  description nvarchar(1000),
  PRIMARY KEY(type_id),
  FOREIGN KEY(product_id) REFERENCES Product(product_id)
)

GO
CREATE TABLE ProductIngredient(
  product_ingredient_id INT IDENTITY(1,1),
  ingredient_id INT,
  product_id VARCHAR(50) NOT NULL,
  description nvarchar(1000),
  PRIMARY KEY(ingredient_id),
  FOREIGN KEY(product_id) REFERENCES Product(product_id),
  FOREIGN KEY(ingredient_id) REFERENCES Ingredient(ingredient_id)
)

GO
CREATE TABLE Result(
  result_id INT IDENTITY(1,1),
  content nvarchar(300),
  image nvarchar(MAX),
  PRIMARY KEY(result_id)
)

GO
CREATE TABLE Question(
  question_id INT IDENTITY(1,1),
  content nvarchar(300) NOT NULL,
  PRIMARY KEY(question_id)
)

GO
CREATE TABLE Answer(
  answer_id INT IDENTITY(1,1),
  content nvarchar(300) NOT NULL,
  linked_answer_id INT DEFAULT NULL,
  result_id INT DEFAULT NULL,
  PRIMARY KEY(answer_id),
  FOREIGN KEY(result_id) REFERENCES Result(result_id)
)