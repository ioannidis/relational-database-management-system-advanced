--------------------------------------------------------------------------------

DROP INDEX IF EXISTS vehicles_data_missing_index;

CREATE INDEX
    vehicles_data_missing_index
ON
    vehicles_data_missing(sex_of_driver);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS vehicles_female_index;

CREATE INDEX
    vehicles_female_index
ON
    vehicles_female(sex_of_driver);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS vehicles_male_index;

CREATE INDEX
    vehicles_male_index
ON
    vehicles_male(sex_of_driver);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS vehicles_not_known_index;

CREATE INDEX
    vehicles_not_known_index
ON
    vehicles_not_known(sex_of_driver);

--------------------------------------------------------------------------------
