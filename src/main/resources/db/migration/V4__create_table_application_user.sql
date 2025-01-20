CREATE TYPE user_type AS ENUM ('ADM', 'PROFESSIONAL', 'CLIENT');
CREATE TABLE application_user(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    user_type user_type NOT NULL,
    establishment_id SERIAL,
    email TEXT UNIQUE,
    password TEXT UNIQUE,
    FOREIGN KEY (establishment_id) REFERENCES establishment(id)

);