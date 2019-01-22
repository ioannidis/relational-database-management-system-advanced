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
DROP INDEX IF EXISTS vehicles_data_missing_index;
DROP INDEX IF EXISTS vehicles_female_index;
DROP INDEX IF EXISTS vehicles_male_index;
DROP INDEX IF EXISTS vehicles_not_known_index;

--------------------------------------------------------------------------------

CREATE INDEX
    vehicles_data_missing_index
ON
    vehicles_data_missing(sex_of_driver);

--------------------------------------------------------------------------------

CREATE INDEX
    vehicles_female_index
ON
    vehicles_female(sex_of_driver);

--------------------------------------------------------------------------------

CREATE INDEX
    vehicles_male_index
ON
    vehicles_male(sex_of_driver);

--------------------------------------------------------------------------------

CREATE INDEX
    vehicles_not_known_index
ON
    vehicles_not_known(sex_of_driver);

--------------------------------------------------------------------------------
