CREATE OR REPLACE PROCEDURE insert_investor(
    name VARCHAR(255),
    surname VARCHAR(255),
    date_of_birth DATE,
    cell_number VARCHAR(255),
    email VARCHAR(255),
    address_id INTEGER)
LANGUAGE "plpgsql"
AS $$
BEGIN
    INSERT INTO public.investor (name, surname, date_of_birth, cell_number, email, address_id)
    VALUES ($1, $2, $3, $4, $5, $6);

    RETURN;
END;
$$;