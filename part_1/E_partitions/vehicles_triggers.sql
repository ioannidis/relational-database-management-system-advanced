--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION vehicles_partitioner()
RETURNS TRIGGER AS $$
BEGIN
    IF ( NEW.sex_of_driver = 'Data missing or out of range'  ) THEN
        INSERT INTO vehicles_data_missing VALUES (NEW.*);
    ELSIF (NEW.sex_of_driver = 'Female') THEN
        INSERT INTO vehicles_female VALUES (NEW.*);
    ELSIF (NEW.sex_of_driver = 'Male') THEN
        INSERT INTO vehicles_male VALUES (NEW.*);
	ELSIF (NEW.sex_of_driver = 'Not known') THEN
        INSERT INTO vehicles_not_known VALUES (NEW.*);
    ELSE
        RAISE EXCEPTION 'Date out of range.  Fix the vehicles_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

--------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS insert_vehicles_trigger;

CREATE TRIGGER insert_vehicles_trigger
    BEFORE INSERT ON vehicle_information
    FOR EACH ROW EXECUTE PROCEDURE vehicles_partitioner();

--------------------------------------------------------------------------------
