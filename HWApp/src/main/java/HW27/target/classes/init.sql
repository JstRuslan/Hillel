CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                age INT NOT NULL,
                email VARCHAR(255) NOT NULL UNIQUE,
                CHECK (LENGTH(name) > 2),
                CHECK (age > 0)
            );

TRUNCATE TABLE users;

INSERT INTO users (name, age, email) VALUES
('John', 30, 'john@example.com'),
('Alice', 25, 'alice@example.com'),
('Bob', 35, 'bob@example.com');