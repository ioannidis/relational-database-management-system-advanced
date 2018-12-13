CREATE TABLE vehicles_Data_missing (
		CHECK ( sex_of_driver = 'Data missing or out of range' )
		) INHERITS (vehicle_information);

		CREATE INDEX vehicles_Data_missing_index ON vehicles_Data_missing (sex_of_driver);

CREATE TABLE vehicles_Female (
		CHECK ( sex_of_driver = 'Female' )
		) INHERITS (vehicle_information);

		CREATE INDEX vehicles_Female_index ON vehicles_Female (sex_of_driver);

CREATE TABLE vehicles_Male (
		CHECK ( sex_of_driver = 'Male' )
		) INHERITS (vehicle_information);

		CREATE INDEX vehicles_Male_index ON vehicles_Male (sex_of_driver);

CREATE TABLE vehicles_Not_Known (
		CHECK (sex_of_driver = 'Not known')
		) INHERITS (vehicle_information);

		CREATE INDEX vehicles_Not_Known_index ON vehicles_Not_Known (sex_of_driver);