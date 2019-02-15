DROP TABLE bet;
DROP TABLE race_info;
DROP TABLE client;
DROP TABLE horse;
DROP TABLE race;

CREATE TABLE bet (
    id          INTEGER NOT NULL,
    amount      NUMBER NOT NULL,
    client_id   INTEGER NOT NULL,
    horse_id    INTEGER NOT NULL,
    race_id     INTEGER NOT NULL
);

ALTER TABLE bet ADD CONSTRAINT bet_pk PRIMARY KEY ( id );

CREATE TABLE client (
    id    INTEGER NOT NULL,
    fio   VARCHAR2(50) NOT NULL
);

ALTER TABLE client ADD CONSTRAINT client_pk PRIMARY KEY ( id );

CREATE TABLE horse (
    id        INTEGER NOT NULL,
    nikname   VARCHAR2(50) NOT NULL
);

ALTER TABLE horse ADD CONSTRAINT horse_pk PRIMARY KEY ( id );

CREATE TABLE race (
    id          INTEGER NOT NULL,
    distance    NUMBER NOT NULL,
    race_date   DATE NOT NULL
);

ALTER TABLE race ADD CONSTRAINT race_pk PRIMARY KEY ( id );

CREATE TABLE race_info (
    horse_id   INTEGER NOT NULL,
    race_id    INTEGER NOT NULL,
    position   INTEGER
);

ALTER TABLE race_info ADD CONSTRAINT race_info_pk PRIMARY KEY ( horse_id,
                                                                race_id );

ALTER TABLE bet
    ADD CONSTRAINT bet_client_fk FOREIGN KEY ( client_id )
        REFERENCES client ( id );

ALTER TABLE bet
    ADD CONSTRAINT bet_horse_fk FOREIGN KEY ( horse_id )
        REFERENCES horse ( id );

ALTER TABLE bet
    ADD CONSTRAINT bet_race_fk FOREIGN KEY ( race_id )
        REFERENCES race ( id );

ALTER TABLE race_info
    ADD CONSTRAINT race_info_horse_fk FOREIGN KEY ( horse_id )
        REFERENCES horse ( id );

ALTER TABLE race_info
    ADD CONSTRAINT race_info_race_fk FOREIGN KEY ( race_id )
        REFERENCES race ( id );


CREATE OR REPLACE TRIGGER horse_in_race_repeat
BEFORE INSERT
  ON RACE_INFO FOR EACH ROW
DECLARE
  TOTAL_HORSE NUMBER;
  NEW_RACE_DATE DATE;
BEGIN

  SELECT trunc(race_date) INTO NEW_RACE_DATE
  from race
  where id = :new.race_id;

  SELECT COUNT(*) INTO TOTAL_HORSE
  FROM race r
  JOIN RACE_INFO ri
    ON r.id = ri.race_id
  WHERE ri.HORSE_ID = :new.horse_id and NEW_RACE_DATE  = trunc(r.race_date);


  IF TOTAL_HORSE > 0
    THEN RAISE_APPLICATION_ERROR(-20001, 'Error: can not added horse. It has already race in that date');
  END IF;

END horse_in_race_repeat;

INSERT INTO CLIENT VALUES (1, 'TEST1');
INSERT INTO CLIENT VALUES (2, 'TEST2');
INSERT INTO CLIENT VALUES (3, 'TEST3');

INSERT INTO HORSE VALUES (1, 'nik1');
INSERT INTO HORSE VALUES (2, 'nik2');
INSERT INTO HORSE VALUES (3, 'nik3');

INSERT INTO RACE VALUES (1, 23.4, TO_DATE('2019/02/10', 'yyyy/mm/dd'));
INSERT INTO RACE VALUES (2, 3.4, TO_DATE('2019/02/11', 'yyyy/mm/dd'));
INSERT INTO RACE VALUES (3, 53.5, TO_DATE('2019/02/10', 'yyyy/mm/dd'));

INSERT INTO race_info VALUES (1, 1, NULL);
INSERT INTO race_info VALUES (1, 2, NULL);
INSERT INTO race_info VALUES (3, 1, NULL);
INSERT INTO race_info VALUES (3, 2, NULL);

INSERT INTO bet VALUES (1, 12.3, 1, 1, 1);
INSERT INTO bet VALUES (2, 2.3, 1, 3, 1);
INSERT INTO bet VALUES (3, 6.3, 1, 1, 1);
INSERT INTO bet VALUES (4, 9.3, 2, 1, 2);
INSERT INTO bet VALUES (5, 21.3, 1, 3, 1);
INSERT INTO bet VALUES (6, 6.2, 2, 3, 2);


/* 
SELECT h.nikname, r.id FROM RACE r
JOIN RACE_INFO r_i
on r.id = r_i.RACE_ID
JOIN HORSE h
on h.id = r_i. HORSE_ID

SELECT * FROM RACE r
JOIN RACE_INFO r_i
on r.id = r_i.RACE_ID
WHERE trunc(r_i."date") = trunc(SYSDATE)
*/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             10
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
