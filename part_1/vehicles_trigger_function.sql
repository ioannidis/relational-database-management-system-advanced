CREATE OR REPLACE FUNCTION vehicles_insert_trigger()
RETURNS TRIGGER AS $$
BEGIN
    IF ( NEW.sex_of_driver = 'Data missing or out of range'  ) THEN
        INSERT INTO vehicles_Data_missing VALUES (NEW.*);
    ELSIF (NEW.sex_of_driver = 'Female') THEN
        INSERT INTO vehicles_Female VALUES (NEW.*);
    ELSIF (NEW.sex_of_driver = 'Male') THEN
        INSERT INTO vehicles_Male VALUES (NEW.*);
	ELSIF (NEW.sex_of_driver = 'Not known') THEN
        INSERT INTO vehicles_Not_Known VALUES (NEW.*);
    ELSE
        RAISE EXCEPTION 'Date out of range.  Fix the vehicles_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;