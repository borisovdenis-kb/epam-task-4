package ru.intodayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CreateTestData {
    public static List<Author> createAuthorList() {
        List<Author> authors = new ArrayList<>();
        Author a0 = new Author(
                "Чингиз Айтматов",
                LocalDate.of(1928, 12, 12),
                LocalDate.of(2008, 6, 10),
                Gender.MAN
        );
        Author a1 = new Author(
                "Карл Саган",
                LocalDate.of(1934, 11, 23),
                LocalDate.of(1996, 12, 20),
                Gender.MAN
        );
        Author a2 = new Author(
                "Джоан Роулинг",
                LocalDate.of(1965, 7, 31),
                Gender.WOMAN
        );
        Author a3 = new Author(
                "Чак Паланик",
                LocalDate.of(1962, 2, 21),
                Gender.MAN
        );
        Author a4 = new Author(
                "Стивен Кинг",
                LocalDate.of(1947, 9, 21),
                Gender.MAN
        );

        authors.add(a0);
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);

        return authors;
    }

    public static List<Book> createBookList(List<Author> authors) {
        List<Book> books = new ArrayList<>();
        Book b0 = new Book(
                "Буранный полустанок",
                LocalDate.of(1980, 1, 1),
                authors.get(0)      // Чингиз Айтматов
        );
        Book b1 = new Book(
                "Уцелевший",
                LocalDate.of(1999, 2, 17),
                authors.get(3)      // Чак Паланик
        );
        Book b2 = new Book(
                "Сияние: Наследие",
                LocalDate.of(2016, 1, 1),
                authors.get(2),     // Джоан Роулинг
                authors.get(4)      // Стивен Кинг
        );
        Book b3 = new Book(
                "Космос",
                LocalDate.of(1980, 1, 1),
                authors.get(1)      // Карл Саган
        );
        Book b4 = new Book(
                "Стихи о науке",
                LocalDate.of(1995, 1, 1),
                authors.get(0),     // Чингиз Айтматов
                authors.get(1)      // Карл Саган
        );

        books.add(b0);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        return books;
    }
}
