--------------------------------------------------------------------------------

-- Accident Information Indexes

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS accidents_2005to2007_index;

CREATE INDEX
    accidents_2005to2007_index
ON
    accidents_2005to2007(year);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS accidents_2008to2010_index;

CREATE INDEX
    accidents_2008to2010_index
    ON
    accidents_2008to2010(year);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS accidents_2011to2013_index;

CREATE INDEX
    accidents_2011to2013_index
ON
    accidents_2011to2013(year);

--------------------------------------------------------------------------------

DROP INDEX IF EXISTS accidents_2014to2016_index;

CREATE INDEX
    accidents_2014to2016_index
ON
    accidents_2014to2016(year);

--------------------------------------------------------------------------------

-- Vehicle Information Indexes

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
