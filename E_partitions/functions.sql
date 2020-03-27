--------------------------------------------------------------------------------

-- Accident Information Partitioning Function

--------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION accidents_partitioner()
RETURNS TRIGGER AS $$
BEGIN
    IF ( CAST(NEW.year AS INT) >= 2005 AND CAST(NEW.year AS INT)<= 2007 ) THEN
        INSERT INTO accidents_2005to2007 VALUES (NEW.*);
    ELSIF ( CAST(NEW.year AS INT) >= 2008 AND CAST(NEW.year AS INT)<= 2010 ) THEN
        INSERT INTO accidents_2008to2010 VALUES (NEW.*);
    ELSIF ( CAST(NEW.year AS INT) >= 2011 AND CAST(NEW.year AS INT)<= 2013 ) THEN
        INSERT INTO accidents_2011to2013 VALUES (NEW.*);
	ELSIF ( CAST(NEW.year AS INT) >= 2014 AND CAST(NEW.year AS INT)<= 2016 ) THEN
        INSERT INTO accidents_2014to2016 VALUES (NEW.*);
    ELSE
        RAISE EXCEPTION 'Out of range year value. Fix the accidents_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

--------------------------------------------------------------------------------

-- Vehicle Information Partitioning Function

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
        RAISE EXCEPTION 'Unknown sex_of_driver value. Fix the vehicles_insert_trigger() function!';
    END IF;
    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

--------------------------------------------------------------------------------
