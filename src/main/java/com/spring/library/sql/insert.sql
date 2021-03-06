
Insert into author Values (1,'Американский писатель','Стивен Кинг'),
                          (2,'Британская писателница','Джоан Роулинг'),
                          (3,'Австралийская писательница','Коллинь Маккалоу');

Insert into publisher Values (1,'Американский издательская компания','Doubleday'),
                             (2,'Одно из книжных издательство Великобритании','Bloomsbury Publisher'),
                             (3,'Одно из крупнейших компаний в мире','HarperCollins');

Insert into book Values (1,'Идея романа пришла Книгу во сне во время поездки в отель Сенли','Сияние','451584549','Сияние','54687',1, 1),
                        (2,'Книга выиграла несколько наград','Harry Potter','5353014359','Harry Potter и Дары Смерти','55655',2,2),
                        (3,'Роман стал бестселлером. проведённым одним из лондонких университетов, каждую минуту в мире продаются 2 экземпляра','The Thorn Birds','9780060129569','Поющие в терновнике','984688',3,3);

Insert into author_books Values (1,1),(2,2),(3,3);

Insert into publisher_books Values (1,1),(2,2),(3,3);