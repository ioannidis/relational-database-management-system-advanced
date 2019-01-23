--------------------------------------------------------------------------------

-- Απενεργοποιούμε αυτό το setting της postgres για να μην χρησιμοποιεί
-- τον δικό της αλγόριθμο sequence scan στα queries που τρέχουμε.

SET enable_seqscan = off;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα b-tree πάνω σε τρία πεδία του accidents έτσι ώστε
-- να επιταχύνουμε τα joins, where και group by στο query. Περιορίζουμε το
-- δέντρο στα δεδομένα που αφορούν το ερώτημα μόνο για να μειώσουμε το κόστος.

DROP INDEX IF EXISTS query_4_accidents;

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

DROP INDEX IF EXISTS query_4_vehicles;

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
