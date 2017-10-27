USE adlister_team;
CREATE FUNCTION search (search VARCHAR(250)) RETURNS ;
DECLARE search VARCHAR(250);
SELECT * from ads WHERE title LIKE CONCAT('%', search(), '%');
SELECT search('a');