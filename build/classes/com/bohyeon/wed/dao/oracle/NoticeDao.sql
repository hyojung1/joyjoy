
--GET LIST
SELECT * FROM NOTICE_VIEW WHERE ? LIKE ? 

SELECT * 
FROM(
		SELECT ROWNUM NUM , N.* 
		FROM (
				SELECT *
				FROM
						NOTICE_VIEW 
				WHERE TITLE LIKE '%%' 
 				ORDER BY REGDATE DESC
		)N
)

WHERE ROWNUM  BETWEEN 11 AND 20;

SELECT N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT, COUNT(C.CODE) CMTCNT 
FROM
		NOTICE N LEFT OUTER  JOIN "COMMENT" C
		ON N.CODE = C.NOTICE_CODE
		GROUP BY N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT
		
SELECT CODE FROM NOTICE

SELECT CODE FROM NOTICE WHERE CODE = (SELECT MAX (TO_NUMBER(CODE)) FROM NOTICE)

-----------insert( ) QUERY-----------------------------------------

SELECT NVL(MAX (TO_NUMBER(CODE)),0) FROM NOTICE 

SELECT * FROM NOTICE





