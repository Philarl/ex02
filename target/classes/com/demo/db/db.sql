CREATE TABLE TBL_BOARD (
    BNO     NUMBER      PRIMARY KEY,
    TITLE   VARCHAR2(50)    NOT NULL,
    WRITER  VARCHAR2(50)    NOT NULL,
    CONTENT VARCHAR2(1000)  NOT NULL,
    REGDATE DATE    DEFAULT SYSDATE,
    UPDATEDDATE  DATE    DEFAULT SYSDATE
);

CREATE SEQUENCE SEQ_BOARD;

SELECT bno, title, writer, content, regdate, updateddate FROM tbl_board ORDER BY regdate desc;