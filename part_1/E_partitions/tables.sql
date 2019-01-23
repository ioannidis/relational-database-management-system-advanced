--------------------------------------------------------------------------------

-- Accident Information Tables

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS accidents_2005to2007;

CREATE TABLE accidents_2005to2007 (
    CHECK ( 
        CAST(year AS INT) >= 2005 
        AND 
        CAST(year AS INT) <= 2007
    )
) INHERITS (accident_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS accidents_2008to2010;

CREATE TABLE accidents_2008to2010 (
    CHECK ( 
        CAST(year AS INT) >= 2008 
        AND 
        CAST(year AS INT)<= 2010
    )
) INHERITS (accident_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS accidents_2011to2013;

CREATE TABLE accidents_2011to2013 (
    CHECK ( 
        CAST(year AS INT) >= 2011 
        AND 
        CAST(year AS INT) <= 2013 
    )
) INHERITS (accident_information);

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS accidents_2014to2016;

CREATE TABLE accidents_2014to2016 (
    CHECK ( 
        CAST(year AS INT) >= 2014 
        AND 
        CAST(year AS INT) <= 2016
    )
) INHERITS (accident_information);

--------------------------------------------------------------------------------

-- Vehicle Information Tables

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
