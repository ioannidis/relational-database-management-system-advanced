SELECT 
    vehicles.age_band_of_driver AS AGE,
    accidents.urban_or_rural_area AS AREA,
    COUNT(vehicles) AS ACCIDENTS
FROM
    vehicle_information AS vehicles
INNER JOIN
    accident_information AS accidents
ON
    vehicles.accident_index = accidents.accident_index 
WHERE
    vehicles.age_band_of_driver = '26 - 35' AND accidents.urban_or_rural_area = 'Urban' 
AND
    accidents.date < '2010-1-1'
GROUP BY
    vehicles.age_band_of_driver, accidents.urban_or_rural_area;
