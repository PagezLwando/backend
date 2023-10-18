-- PROCEDURE: public.getallproducts()

-- DROP PROCEDURE IF EXISTS public.getallproducts();

CREATE OR REPLACE PROCEDURE public.getAllProducts()
LANGUAGE 'plpgsql'
AS $$
BEGIN
    PERFORM id, type, current_balance, investor_id
    FROM product
    ORDER BY id ASC;
END;
$$;