USE autohelp;
CREATE TABLE ads_Table(
  id int NOT NULL AUTO_INCREMENT,
  ad varchar(150),
  PRIMARY KEY (id)
);

DROP TABLE adsTable;

INSERT INTO autohelp.ads_table (ad) VALUES('Вам пора повторно записаться на Тех.Осмотр');
INSERT INTO autohelp.ads_table (ad) VALUES('Только сегодня при записи на ТО брелок и ароматизатор в подарок');