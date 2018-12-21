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
