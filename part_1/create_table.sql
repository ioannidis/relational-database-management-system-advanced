--------------------------------------------------------------------------------

DROP TABLE IF EXISTS accident_information;

CREATE TABLE accident_information(
    id                  serial NOT NULL,
    accident_index      varchar(100), 
    first_road_class    varchar(30), 
    accident_severity   varchar(50), 
    date                date, 
    urban_or_rural_area varchar(20), 
    weather_conditions  varchar(80), 
    year                int, 
    inscotland          varchar(10)
);

--------------------------------------------------------------------------------

COPY
    accident_information
FROM
    '/path/to/db2_Accident_Information.csv' DELIMITER ',' CSV HEADER;

--------------------------------------------------------------------------------

DROP TABLE IF EXISTS vehicle_information;

CREATE TABLE vehicle_information(
    id                  serial NOT NULL,
    accident_index      varchar(100),
    age_band_of_driver  varchar(50),
    age_of_vehicle      decimal,
    make                varchar(50),
    model               varchar(50),
    sex_of_driver       varchar(50),
    vehicle_type        varchar(50)
);

--------------------------------------------------------------------------------

COPY
    vehicle_information
FROM
    '/path/to/db2_Vehicle_Information.csv' DELIMITER ',' CSV HEADER;

--------------------------------------------------------------------------------
