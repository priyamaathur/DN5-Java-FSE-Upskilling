SELECT   a.event_id,
         a.session_id  AS session_a,
         a.title       AS title_a,
         b.session_id  AS session_b,
         b.title       AS title_b
FROM     Sessions a
JOIN     Sessions b
  ON     a.event_id   = b.event_id
  AND    a.session_id < b.session_id
  AND    a.start_time < b.end_time
  AND    b.start_time < a.end_time
ORDER BY a.event_id, a.session_id;
