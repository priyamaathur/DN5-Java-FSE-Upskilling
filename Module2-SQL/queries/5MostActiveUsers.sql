SELECT   e.city,
         COUNT(DISTINCT r.user_id) AS unique_registrations
FROM     Registrations r
JOIN     Events e ON r.event_id = e.event_id
GROUP BY e.city
ORDER BY unique_registrations DESC
LIMIT    5;