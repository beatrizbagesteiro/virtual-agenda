CREATE TABLE working_days(
    id SERIAL PRIMARY KEY,
    day_of_week TEXT NOT NULL,
    opening_hour TIME NOT NULL,
    closing_hour TIME NOT NULL,
    establishment_id SERIAL,
    FOREIGN KEY (establishment_id) REFERENCES establishment(id)
);