SELECT e.title, e.city, e.start_date
FROM   Registrations r
JOIN   Events e ON r.event_id = e.event_id
JOIN   Users u  ON r.user_id  = u.user_id
WHERE  u.user_id   = 1            -- change to target user
  AND  e.status    = 'upcoming'
  AND  e.city      = u.city
ORDER BY e.start_date ASC;