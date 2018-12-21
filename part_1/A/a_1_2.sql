SELECT accident_information.first_road_class,accident_information.accident_severity, 
COUNT(accident_information) AS ACCIDENTS
FROM accident_information
GROUP BY accident_information.first_road_class,accident_information.accident_severity


-- Formatted:

SELECT 
    first_road_class,
    accident_severity,
    COUNT(accident_information) AS ACCIDENTS
FROM
    accident_information
GROUP BY
    first_road_class,
    accident_severity
