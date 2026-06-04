SELECT   e.title,
         COUNT(s.session_id) AS peak_sessions
FROM     Sessions s
JOIN     Events   e ON s.event_id = e.event_id
WHERE    TIME(s.start_time) >= '10:00:00'
  AND    TIME(s.start_time) <  '12:00:00'
GROUP BY e.event_id, e.title
ORDER BY peak_sessions DESC;