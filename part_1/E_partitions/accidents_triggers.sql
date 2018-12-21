--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION accidents_partitioner()
RETURNS TRIGGER AS $$
BEGIN
    IF ( CAST(NEW.year AS INT) >= 2005 AND CAST(NEW.year AS INT)<= 2007 ) THEN
        INSERT INTO accidents_2005to2007 VALUES (NEW.*);
    ELSIF ( CAST(NEW.year AS INT) >= 2008 AND CAST(NEW.year AS INT)<= 2010 ) THEN
        INSERT INTO accidents_2008to2010 VALUES (NEW.*);
    ELSIF ( CAST(NEW.year AS INT) >= 2011 AND CAST(NEW.year AS INT)<= 2014 ) THEN
        INSERT INTO accidents_2011to2014 VALUES (NEW.*);
	ELSIF ( CAST(NEW.year AS INT) >= 2014 AND CAST(NEW.year AS INT)<= 2016 ) THEN
        INSERT INTO accidents_2014to2016 VALUES (NEW.*);
    ELSE
        RAISE EXCEPTION 'Date out of range.  Fix the accidents_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

--------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS insert_accidents_trigger;

CREATE TRIGGER insert_accidents_trigger
    BEFORE INSERT ON accident_information
    FOR EACH ROW EXECUTE PROCEDURE accidents_partitioner();

--------------------------------------------------------------------------------
