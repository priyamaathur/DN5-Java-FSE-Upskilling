SELECT   e.title,
         ROUND(AVG(f.rating), 2) AS avg_rating,
         COUNT(f.feedback_id)     AS feedback_count
FROM     Feedback f
JOIN     Events   e ON f.event_id = e.event_id
GROUP BY e.event_id, e.title
HAVING   COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;