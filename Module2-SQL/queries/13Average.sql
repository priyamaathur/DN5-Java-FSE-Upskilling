SELECT   e.city,
         ROUND(AVG(f.rating), 2) AS avg_rating,
         COUNT(f.feedback_id)     AS total_feedback
FROM     Feedback f
JOIN     Events   e ON f.event_id = e.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;