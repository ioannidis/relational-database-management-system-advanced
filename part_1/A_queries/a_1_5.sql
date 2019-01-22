DROP TABLE IF EXISTS accident_sum_per_make;

SELECT
    v.make,
    v.age_band_of_driver,
    a.first_road_class,
    count(v.make) as count INTO accident_sum_per_make
FROM
    vehicle_information AS v
INNER JOIN
    accident_information AS a
ON
    v.accident_index = a.accident_index
WHERE
    v.age_band_of_driver = '26 - 35'
AND
    a.first_road_class = 'A'
AND
    a.year BETWEEN 2010 AND 2012
GROUP BY
    v.make,
    v.age_band_of_driver,
    a.first_road_class
ORDER BY
    count DESC,
    v.make;

SELECT
    v.make,
    v.age_band_of_driver,
    a.first_road_class,
    count(v.make) as count
FROM
    vehicle_information AS v
INNER JOIN
    accident_information AS a
ON
    v.accident_index = a.accident_index
WHERE
    v.age_band_of_driver = '26 - 35'
AND
    a.first_road_class = 'A'
AND
    a.year BETWEEN 2010 AND 2012
GROUP BY
    v.make,
    v.age_band_of_driver,
    a.first_road_class
HAVING
    count(v.make) = ( SELECT max(accident_sum_per_make.count) as count
                      FROM accident_sum_per_make );
