CREATE TABLE service(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    duration INT NOT NULL
);