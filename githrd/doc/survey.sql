CREATE TABLE surveyInfo(
    sino NUMBER(4) 
        CONSTRAINT SI_NO_PK PRIMARY KEY,
    sititle VARCHAR2(50 CHAR)
        CONSTRAINT SI_TITLE_NN NOT NULL,
    sistart DATE,
    siend DATE
);

CREATE TABLE surveyQuest(
    sqno NUMBER(6)
        CONSTRAINT SQ_NO_PK PRIMARY KEY,
    sqbody VARCHAR2(50 CHAR)
        CONSTRAINT SQ_BODY_NN NOT NULL,
    squpno NUMBER(6),
    sq_sino NUMBER(4) 
        CONSTRAINT SQ_SINO_FK REFERENCES surveyInfo(sino)
        CONSTRAINT SQ_SINO_NN NOT NULL
);

CREATE TABLE survey(
    svno NUMBER(6)
        CONSTRAINT SV_NO_PK PRIMARY KEY,
    smno NUMBER(4)
        CONSTRAINT SV_MNO_FK REFERENCES member(mno)
        CONSTRAINT SV_MNO_NN NOT NULL,
    sv_sqno NUMBER(6)
        CONSTRAINT SV_QNO_FK REFERENCES surveyquest(sqno)
        CONSTRAINT SV_QNO_NN NOT NULL,
    svdate DATE DEFAULT sysdate
        CONSTRAINT SV_DATE_NN NOT NULL
);


INSERT INTO
    surveyInfo
VALUES(
    1001, '2022년도 상반기 아이돌 선호도 조사', '2022/06/10', '2022/06/16'
);

INSERT INTO
    surveyQuest
VALUES(
    100001, '제일 좋아하는 여성 아이돌 그룹을 선택하세요.', null, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    100002, '블랙핑크', 100001, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    100003, '에스파', 100001, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    100004, '아이브', 100001, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    100005, '에이핑크', 100001, 1001
);

--------------------------- 2번문제 --------------------------------------------
INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제일 좋아하는 남성 아이돌 그룹을 선택하세요.', null, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '샤이니', 100006, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '엑소', 100006, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), 'BTS', 100006, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '동방신기', 100006, 1001
);

--------------------------- 3번문제 --------------------------------------------
INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제일 좋아하는 남자 아이돌 멤버를 선택하세요.', null, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), 'RM', 100011, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '유노윤호', 100011, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '차은우', 100011, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '런쥔', 100011, 1001
);

--------------------------- 4번문제 --------------------------------------------
INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제일 좋아하는 여자 아이돌 멤버를 선택하세요.', null, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '태연', 100016, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제니', 100016, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '손나은', 100016, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '레이', 100016, 1001
);

--------------------------- 5번문제 --------------------------------------------
INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제일 좋아하는 블랙핑크 멤버를 선택하세요.', null, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '제니', 100021, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '리사', 100021, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '로제', 100021, 1001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(SQNO) + 1 , 100001) FROM surveyquest), '지수', 100021, 1001
);

commit;

SELECT
    sqno qno, sqbody body
FROM
    surveyQuest
WHERE
    sq_sino IN (
        SELECT
            sino
        FROM
            surveyinfo
        WHERE
            SYSDATE BETWEEN sistart AND siend
    )
    AND squpno IS NULL
;

SELECT
    sqno qno, sqbody body
FROM
    surveyQuest
WHERE
    sq_sino IN (
        SELECT
            sino
        FROM
            surveyinfo
        WHERE
            SYSDATE BETWEEN sistart AND siend
    )
    AND squpno = 100001
;


-- 'jennie' 회원이 현재 진행중인 설문들 중 참여하지 않은 
-- 설문들의 갯수를 조회하는 질의명령을 작성하세요.
-- ==> 결과는 1이 조회되어야 한다.

INSERT INTO
    survey(svno, smno, sv_sqno)
VALUES(
    (SELECT NVL(MAX(svno) + 1, 100001) FROM survey),
    1000, 100002
);

INSERT INTO
    survey(svno, smno, sv_sqno)
VALUES(
    (SELECT NVL(MAX(svno) + 1, 100001) FROM survey),
    1000, 100009
);

INSERT INTO
    survey(svno, smno, sv_sqno)
VALUES(
    (SELECT NVL(MAX(svno) + 1, 100001) FROM survey),
    1000, 100014
);

INSERT INTO
    survey(svno, smno, sv_sqno)
VALUES(
    (SELECT NVL(MAX(svno) + 1, 100001) FROM survey),
    1000, 100018
);

INSERT INTO
    survey(svno, smno, sv_sqno)
VALUES(
    (SELECT NVL(MAX(svno) + 1, 100001) FROM survey),
    1000, 100022
);


commit;

SELECT
    COUNT(*)
FROM
    surveyInfo
WHERE
    sysdate BETWEEN sistart AND siend
    AND sino NOT IN (
        SELECT
            DISTINCT sq_sino
        FROM
            survey, surveyquest, member
        WHERE
            sv_sqno = sqno
            AND smno = mno
            AND id = 'jennie'
    )
;


SELECT * FROM SURVEYQUEST;

SELECT
    sino, sititle, 
    (
        SELECT
            count(DISTINCT sq_sino)
        FROM
            survey, surveyQuest, member
        WHERE
            sv_sqno = sqno
            AND smno = mno
            AND id = 'euns'
        GROUP BY
            sq_sino
        HAVING
            sq_sino = sino
    ) cnt
FROM
    surveyinfo
WHERE
    sysdate BETWEEN sistart AND siend
;



