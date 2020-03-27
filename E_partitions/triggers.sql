--------------------------------------------------------------------------------

-- Accident Information Partitioning Trigger

--------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS insert_accidents_trigger on accident_information;

CREATE TRIGGER insert_accidents_trigger
    BEFORE INSERT ON accident_information
    FOR EACH ROW EXECUTE PROCEDURE accidents_partitioner();

--------------------------------------------------------------------------------

-- Vehicle Information Partitioning Trigger

--------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS insert_vehicles_trigger on vehicle_information;

CREATE TRIGGER insert_vehicles_trigger
    BEFORE INSERT ON vehicle_information
    FOR EACH ROW EXECUTE PROCEDURE vehicles_partitioner();

--------------------------------------------------------------------------------
