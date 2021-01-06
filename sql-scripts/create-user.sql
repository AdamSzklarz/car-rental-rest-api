CREATE USER 'rentaluser'@'localhost' IDENTIFIED BY 'rentaluser';
GRANT ALL PRIVILEGES ON * . * TO 'rentaluser'@'localhost';
ALTER USER 'rentaluser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rentaluser';
