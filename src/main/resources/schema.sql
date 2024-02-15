CREATE TABLE IF NOT EXISTS tasks (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    text varchar(50),
    status varchar(30) NOT NULL,
    create_date datetime
);


