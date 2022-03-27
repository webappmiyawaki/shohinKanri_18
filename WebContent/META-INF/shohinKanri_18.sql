CREATE DATABASE shohinkanri_18;

CREATE TABLE shohin(
    shohin_id INTEGER,
    shohin_mei VARCHAR(100),
    shohin_bunrui VARCHAR(100),
    hanbai_tanka INTEGER,
    shiire_tanka INTEGER,
    torokubi VARCHAR(100),
    primary key (shohin_id)
);

DROP TABLE shohin;
TRUNCATE TABLE shohin;

INSERT INTO Shohin VALUES ('0001', 'Tシャツ', '衣服', 1000, 500, '2009-09-20');
INSERT INTO Shohin VALUES ('0002', '穴あけパンチ', '事務用品', 500, 320, '2009-09-11');
INSERT INTO Shohin VALUES ('0003', 'カッターシャツ', '衣服', 4000, 2800, NULL);
INSERT INTO Shohin VALUES ('0004', '包丁', 'キッチン用品', 3000, 2800, '2009-09-20');
INSERT INTO Shohin VALUES ('0005', '圧力鍋', 'キッチン用品', 6800, 5000, '2009-01-15');
INSERT INTO Shohin VALUES ('0006', 'フォーク', 'キッチン用品', 500, NULL, '2009-09-20');
INSERT INTO Shohin VALUES ('0007', 'おろしがね', 'キッチン用品', 880, 790, '2008-04-28');
INSERT INTO Shohin VALUES ('0008', 'ボールペン', '事務用品', 100, NULL, '2009-11-11');

SELECT to_char(shohin_id,'0000'), shohin_bunrui, hanbai_tanka, shiire_tanka FROM shohin ORDER BY shohin_id;

DELETE FROM shohin WHERE shohin_id = 1;