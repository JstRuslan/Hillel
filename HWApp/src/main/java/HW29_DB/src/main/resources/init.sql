CREATE TABLE IF NOT EXISTS employees (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                age INT NOT NULL,
                position VARCHAR(255) NOT NULL,
                salary FLOAT NOT NULL,
                CHECK (LENGTH(name) > 2),
                CHECK (age > 0)
            );

TRUNCATE TABLE employees;

INSERT INTO employees (name, age, position, salary) VALUES
('John', 25, 'manager', 1850),
('Alice', 30, 'supervisor', 2700),
('Bob', 35, 'team leader', 3000),
('John', 42, 'accountant', 2800);
