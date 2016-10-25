


INSERT INTO NOTICES (CODE, TITLE, WRITER, CONTENT)VALUES('1105','SQLSERVER','BH','CONTENT');

DELETE FROM NOTICES WHERE WRITER='BH';

SELECT NVL(MAX (TO_NUMBER(CODE)),0) FROM NOTICE ;

SELECT ISNULL(MAX(CAST(CODE AS INT)),0)+1 AS CODE FROM NOTICES;

--getList query
SELECT * FROM
(
	SELECT
		ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM,
		NOTICES_VIEW.*
	FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
)N
WHERE NUM  BETWEEN 1 AND 10;



--getCount query
SELECT COUNT(*) COUNT FROM
(
	SELECT
		ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM,
		NOTICES_VIEW.*
	FROM NOTICES_VIEW
	WHERE TITLE LIKE '%%'
)N



-----------------------------NOTICES_VIEW--------------------------------------
CREATE VIEW NOTICES_VIEW
AS
SELECT N.* , COUNT(C.CODE) AS CMTCNT
FROM 
	NOTICES N LEFT OUTER JOIN COMMENTS C ON N.CODE = C.NOTICECODE
GROUP BY N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT;
	
SELECT * FROM NOTICES_VIEW;