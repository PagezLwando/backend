CREATE OR REPLACE PROCEDURE getAllInvestors()
LANGUAGE plpgsql
AS $$
    BEGIN
        PERFORM id, name, surname, date_of_birth, cell_number, email, address_id
            FROM public.investor
        ORDER BY name ASC;
    END;
$$;