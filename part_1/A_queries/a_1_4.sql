SELECT 
    vehicles.age_band_of_driver AS AGE,
    accidents.urban_or_rural_area AS area, 
    COUNT(vehicles) AS ACCIDENTS,
    accidents.year AS YEAR
FROM
    vehicle_information AS vehicles
INNER JOIN
    accident_information AS accidents
ON
    vehicles.accident_index = accidents.accident_index 
WHERE
    vehicles.age_band_of_driver = '36 - 45'
AND
    accidents.urban_or_rural_area = 'Rural' 
AND
    accidents.year = '2012'
GROUP BY
    vehicles.age_band_of_driver,
    accidents.urban_or_rural_area,
    accidents.year
