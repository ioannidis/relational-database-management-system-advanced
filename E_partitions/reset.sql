DROP INDEX IF EXISTS accidents_2005to2007_index;
DROP INDEX IF EXISTS accidents_2008to2010_index;
DROP INDEX IF EXISTS accidents_2011to2013_index;
DROP INDEX IF EXISTS accidents_2014to2016_index;
DROP INDEX IF EXISTS vehicles_data_missing_index;
DROP INDEX IF EXISTS vehicles_female_index;
DROP INDEX IF EXISTS vehicles_male_index;
DROP INDEX IF EXISTS vehicles_not_known_index;

DROP TABLE IF EXISTS accidents_2005to2007;
DROP TABLE IF EXISTS accidents_2008to2010;
DROP TABLE IF EXISTS accidents_2011to2013;
DROP TABLE IF EXISTS accidents_2014to2016;
DROP TABLE IF EXISTS vehicles_data_missing;
DROP TABLE IF EXISTS vehicles_female;
DROP TABLE IF EXISTS vehicles_male;
DROP TABLE IF EXISTS vehicles_not_known;

DROP TRIGGER IF EXISTS insert_accidents_trigger on accident_information;
DROP TRIGGER IF EXISTS insert_vehicles_trigger on vehicle_information;

DROP FUNCTION IF EXISTS accidents_partitioner();
DROP FUNCTION IF EXISTS vehicles_partitioner();
