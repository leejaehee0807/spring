CREATE TABLE (
    _id INT AUTO_INCREMENT PRIMARY KEY ,
    task varchar(256) NOT NULL ,
    manager varchar(30) NOT NULL ,
    password varchar(20) NOT NULL ,
    first_date DATETIME NOT NULL ,
    last_date DATETIME NOT NULL ,

);