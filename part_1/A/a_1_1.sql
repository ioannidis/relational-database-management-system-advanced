SELECT accident_information.first_road_class, COUNT(accident_information.first_road_class) AS ACCIDENTS
FROM accident_information
GROUP BY accident_information.first_road_class


-- Formatted:

SELECT
    first_road_class,
    COUNT(first_road_class) AS ACCIDENTS
FROM
    accident_information
GROUP BY
    first_road_class
