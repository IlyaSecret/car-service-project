USE autohelp;

CREATE TABLE autohelp.history(
	id int NOT NULL AUTO_INCREMENT,
	employee_name varchar(150),
    works varchar(150),
    date varchar(150),
    PRIMARY KEY (id)
);

INSERT INTO autohelp.history VALUES(1, 'Устинов Валентин Куприянович', 'Масло ДВС', '14.12.2022');
INSERT INTO autohelp.history VALUES(2, 'Большаков Трофим Игнатьевич', 'Электроника', '07.02.2021');
INSERT INTO autohelp.history VALUES(3, 'Третьяков Петр Семенович', 'Ремонт системы охлаждения', '05.02.2022');
INSERT INTO autohelp.history VALUES(4, 'Исаков Эльдар Викторович', 'АКБ', '16.09.2022');
INSERT INTO autohelp.history VALUES(5, 'Сергеев Панкратий Куприянович', 'Термостой', '30.04.2022');