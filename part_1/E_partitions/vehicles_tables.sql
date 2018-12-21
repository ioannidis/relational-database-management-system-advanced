--------------------------------------------------------------------------------

DROP TABLE IF EXISTS vehicles_data_missing;

CREATE TABLE vehicles_data_missing (
    CHECK (
        sex_of_driver = 'Data missing or out of range' 
    )
) INHERITS (vehicle_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS vehicles_female;

CREATE TABLE vehicles_female (
    CHECK (
        sex_of_driver = 'Female'
    )
) INHERITS (vehicle_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS vehicles_male;

CREATE TABLE vehicles_male (
    CHECK (
        sex_of_driver = 'Male'
    )
) INHERITS (vehicle_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS vehicles_not_known;

CREATE TABLE vehicles_not_known (
    CHECK (
        sex_of_driver = 'Not known'
    )
) INHERITS (vehicle_information);

--------------------------------------------------------------------------------
