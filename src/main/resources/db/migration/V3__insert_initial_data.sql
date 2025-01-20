DO $$
DECLARE
    establishment_id BIGINT;
BEGIN
    INSERT INTO establishment(name, address, phone_number) VALUES
    ('Estabelecimento Teste', 'Rua 700, Bairro XYZ', '47912345678');

    SELECT id INTO establishment_id
    FROM establishment
    WHERE name = 'Estabelecimento Teste';

    INSERT INTO working_days(establishment_id, day_of_week, opening_hour, closing_hour)
    VALUES
    (establishment_id, 'Monday', '08:00:00', '19:00:00'),
    (establishment_id, 'Tuesday', '08:00:00', '19:00:00'),
    (establishment_id, 'Wednesday', '08:00:00', '19:00:00'),
    (establishment_id, 'Thursday', '08:00:00', '19:00:00'),
    (establishment_id, 'Friday', '08:00:00', '19:00:00'),
    (establishment_id, 'Saturday', '08:00:00', '12:00:00');
END $$;
