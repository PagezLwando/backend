CREATE OR REPLACE PROCEDURE update_investor(
    id INTEGER,
    name VARCHAR(255),
    surname VARCHAR(255),
    date_of_birth DATE,
    cell_number VARCHAR(255),
    email VARCHAR(255),
    address_id INTEGER)
LANGUAGE "plpgsql"
AS $$
BEGIN
    UPDATE public.investor
    SET name = $2,
        surname = $3,
        date_of_birth = $4,
        cell_number = $5,
        email = $6,
        address_id = $7
    WHERE id = $1;

    RETURN;
END;
$$;