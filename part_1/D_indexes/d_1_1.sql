--------------------------------------------------------------------------------

-- Απενεργοποιούμε αυτό το setting της postgres για να μην χρησιμοποιεί
-- τον δικό της αλγόριθμο sequence scan στα queries που τρέχουμε.

SET enable_seqscan = off;

--------------------------------------------------------------------------------

-- Δημιουργούμε ένα multicolumn b-tree πάνω σε ένα πεδία του accidents
-- έτσι ώστε να επιταχύνουμε το group by του ερωτήματος. Καθορίζουμε ότι η
-- διάταξη του δέντρου θα είναι ascending και όλα τα null μπαίνουν στο τέλος.

DROP INDEX IF EXISTS query_1;

CREATE INDEX
    query_1
ON
    accident_information
USING
    BTREE(  first_road_class ASC NULLS LAST );

--------------------------------------------------------------------------------

-- https://www.postgresql.org/docs/11/indexes.html
-- https://www.postgresql.org/docs/11/sql-createindex.html
-- https://www.postgresql.org/docs/11/sql-dropindex.html
-- https://www.postgresql.org/docs/11/sql-alterindex.html

--------------------------------------------------------------------------------
