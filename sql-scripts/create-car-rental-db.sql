CREATE DATABASE IF NOT EXISTS car_rental;
USE car_rental;

CREATE TABLE car (
car_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
reg_number VARCHAR(8) NOT NULL,
mark VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
is_available BOOLEAN DEFAULT TRUE,
PRIMARY KEY(car_id)
);

CREATE TABLE customer (
customer_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
email VARCHAR(40) NOT NULL,
PRIMARY KEY(customer_id)
);

CREATE TABLE rent (
rent_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
car_id SMALLINT UNSIGNED NOT NULL,
customer_id SMALLINT UNSIGNED NOT NULL,
rent_date DATETIME NOT NULL,
return_date DATETIME,
PRIMARY KEY(rent_id),
FOREIGN KEY(car_id) REFERENCES car(car_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

INSERT INTO car(reg_number, mark, model) VALUES
('PO 12345', 'Toyota', 'Yaris'),
('PO 67890', 'Opel', 'Astra'),
('PZ 13579', 'Honda', 'Civic'),
('PZ 24680', 'Seat', 'Ibiza'),
('PK 12589', 'Skoda', 'Octavia');

INSERT INTO customer(first_name, last_name, email) VALUES
('Jan', 'Kowalski', 'jankowalski@gmail.com'),
('Michał', 'Nowak', 'michalnowak@wp.pl'),
('Anna', 'Nowak', 'annanowak@wp.pl'),
('Agata', 'Wojciechowska', 'awojciechowska@gmail.com'),
('John', 'Smith', 'john.smith@gmail.com');
