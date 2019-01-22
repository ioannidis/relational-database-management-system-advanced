--------------------------------------------------------------------------------

-- Απενεργοποιούμε αυτό το setting της postgres για να μην χρησιμοποιεί
-- τον δικό της αλγόριθμο sequence scan στα queries που τρέχουμε.

SET enable_seqscan = off;

--------------------------------------------------------------------------------

-- Διαγράφουμε όλα τα index σχετίζονταιμε άλλα ερωτήματα της εργασίας.

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
DROP INDEX IF EXISTS vehicles_data_missing_index;
DROP INDEX IF EXISTS vehicles_female_index;
DROP INDEX IF EXISTS vehicles_male_index;
DROP INDEX IF EXISTS vehicles_not_known_index;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα b-tree πάνω σε τρία πεδία του accidents έτσι ώστε
-- να επιταχύνουμε τα joins, where και group by στο query. Περιορίζουμε το
-- δέντρο στα δεδομένα που αφορούν το ερώτημα μόνο για να μειώσουμε το κόστος.

CREATE INDEX
    query_4_accidents
ON
    accident_information
USING
    BTREE(  accident_index      ASC NULLS LAST,
            year                ASC NULLS LAST,
            urban_or_rural_area ASC NULLS LAST  )
WHERE
    urban_or_rural_area = 'Rural'
AND
    year = '2012';

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα b-tree πάνω σε δύο πεδία του vehicles έτσι ώστε
-- να επιταχύνουμε τα joins, where και group by στο query. Περιορίζουμε το
-- δέντρο στα δεδομένα που αφορούν το ερώτημα μόνο για να μειώσουμε το κόστος.

CREATE INDEX
    query_4_vehicles
ON
    vehicle_information
USING
    BTREE(  accident_index      ASC NULLS LAST,
            age_band_of_driver  ASC NULLS LAST  )
WHERE
    age_band_of_driver = '36 - 45';

--------------------------------------------------------------------------------

-- https://www.postgresql.org/docs/11/indexes.html
-- https://www.postgresql.org/docs/11/sql-createindex.html
-- https://www.postgresql.org/docs/11/sql-dropindex.html
-- https://www.postgresql.org/docs/11/sql-alterindex.html

--------------------------------------------------------------------------------
