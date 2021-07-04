Create table  Author(
                        author_id BIGINT primary key ,
                        author_name VARCHAR,
                        author_description VARCHAR

);
Create table  Book(
                      book_id BIGINT primary key,
                      book_name VARCHAR,
                      book_sub_name VARCHAR,
                      book_serial_name VARCHAR,
                      book_description VARCHAR
);
Create table  Publisher(
                           publisher_id BIGINT primary key,
                           publisher_name VARCHAR,
                           publisher_description VARCHAR

);
Create table  author_books(
                              author_author_id BIGINT references author(author_id),
                              books_book_id BIGINT references book(book_id)


);
Create table  publisher_books(
                                 publisher_publisher_id BIGINT references publisher_(book_id),
                                 books_book_id BIGINT references book(book_id)
);