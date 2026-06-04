SELECT e.event_id, e.title, e.status
FROM   Events e
WHERE  e.event_id NOT IN (
  SELECT DISTINCT event_id FROM Sessions
);