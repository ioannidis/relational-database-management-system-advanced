SELECT
    first_road_class,
    COUNT(first_road_class) AS ACCIDENTS
FROM
    accident_information
GROUP BY
    first_road_class;
