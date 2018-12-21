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
