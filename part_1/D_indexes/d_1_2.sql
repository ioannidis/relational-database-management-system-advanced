--------------------------------------------------------------------------------

-- Απενεργοποιούμε αυτό το setting της postgres για να μην χρησιμοποιεί
-- τον δικό της αλγόριθμο sequence scan στα queries που τρέχουμε.

SET enable_seqscan = off;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα multicolumn b-tree πάνω σε δύο πεδία του accidents
-- έτσι ώστε να επιταχύνουμε το group by του ερωτήματος.

DROP INDEX IF EXISTS query_2;

CREATE INDEX
    query_2
ON
    accident_information
USING
    BTREE(  first_road_class    ASC NULLS LAST,
            accident_severity   ASC NULLS LAST  );

--------------------------------------------------------------------------------

-- https://www.postgresql.org/docs/11/indexes.html
-- https://www.postgresql.org/docs/11/sql-createindex.html
-- https://www.postgresql.org/docs/11/sql-dropindex.html
-- https://www.postgresql.org/docs/11/sql-alterindex.html

--------------------------------------------------------------------------------
