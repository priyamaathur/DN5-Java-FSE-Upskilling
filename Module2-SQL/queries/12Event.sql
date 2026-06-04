SELECT   e.title,
         COUNT(s.session_id) AS session_count
FROM     Events   e
JOIN     Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING   COUNT(s.session_id) = (
  SELECT MAX(cnt)
  FROM   (SELECT COUNT(*) AS cnt
          FROM   Sessions
          GROUP BY event_id) sub
);