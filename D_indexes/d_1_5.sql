--------------------------------------------------------------------------------

-- Απενεργοποιούμε αυτό το setting της postgres για να μην χρησιμοποιεί
-- τον δικό της αλγόριθμο sequence scan στα queries που τρέχουμε.

SET enable_seqscan = off;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα b-tree πάνω σε τρία πεδία του accidents έτσι ώστε
-- να επιταχύνουμε τα joins, where και group by στο query. Περιορίζουμε το
-- δέντρο στα δεδομένα που αφορούν το ερώτημα μόνο για να μειώσουμε το κόστος.

DROP INDEX IF EXISTS query_5_accidents;

CREATE INDEX
    query_5_accidents
ON
    accident_information
USING
    BTREE(  accident_index      ASC NULLS LAST,
            first_road_class    ASC NULLS LAST,
            year                ASC NULLS LAST  )
WHERE
    first_road_class = 'A'
AND
    year BETWEEN 2010 AND 2012;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα b-tree πάνω σε τρία πεδία του vehicles έτσι ώστε
-- να επιταχύνουμε τα joins, where και group by στο query. Περιορίζουμε το
-- δέντρο στα δεδομένα που αφορούν το ερώτημα μόνο για να μειώσουμε το κόστος.

DROP INDEX IF EXISTS query_5_vehicles;

CREATE INDEX
    query_5_vehicles
ON
    vehicle_information
USING
    BTREE(  accident_index      ASC NULLS LAST,
            age_band_of_driver  ASC NULLS LAST,
            make                DESC NULLS LAST  )
WHERE
    age_band_of_driver = '26 - 35';

--------------------------------------------------------------------------------

-- https://www.postgresql.org/docs/11/indexes.html
-- https://www.postgresql.org/docs/11/sql-createindex.html
-- https://www.postgresql.org/docs/11/sql-dropindex.html
-- https://www.postgresql.org/docs/11/sql-alterindex.html

--------------------------------------------------------------------------------
