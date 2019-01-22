--------------------------------------------------------------------------------

-- Διαγράφουμε όλα τα indexes άλλων ερωτημάτων ώστε να χρησιμοποιηθεί μόνο
-- τα index των partitions.

DROP INDEX IF EXISTS query_1;
DROP INDEX IF EXISTS query_2;
DROP INDEX IF EXISTS query_3_accidents;
DROP INDEX IF EXISTS query_3_vehicles;
DROP INDEX IF EXISTS query_4_accidents;
DROP INDEX IF EXISTS query_4_vehicles;
DROP INDEX IF EXISTS query_5_accidents;
DROP INDEX IF EXISTS query_5_vehicles;
DROP INDEX IF EXISTS accidents_2005to2007_index;
DROP INDEX IF EXISTS accidents_2008to2010_index;
DROP INDEX IF EXISTS accidents_2011to2013_index;
DROP INDEX IF EXISTS accidents_2014to2016_index;

--------------------------------------------------------------------------------

CREATE INDEX
    accidents_2005to2007_index
ON
    accidents_2005to2007(year);

--------------------------------------------------------------------------------

CREATE INDEX
    accidents_2008to2010_index
    ON
    accidents_2008to2010(year);

--------------------------------------------------------------------------------

CREATE INDEX
    accidents_2011to2013_index
ON
    accidents_2011to2013(year);

--------------------------------------------------------------------------------

CREATE INDEX
    accidents_2014to2016_index
ON
    accidents_2014to2016(year);

--------------------------------------------------------------------------------
