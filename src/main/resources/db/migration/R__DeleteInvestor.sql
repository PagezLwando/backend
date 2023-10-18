CREATE OR REPLACE PROCEDURE delete_investor(id INTEGER)
LANGUAGE "plpgsql"
AS $$
BEGIN
    DELETE FROM public.investor
    WHERE id = $1;

    RETURN;
END;
$$;