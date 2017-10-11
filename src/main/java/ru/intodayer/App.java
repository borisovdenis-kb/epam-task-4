package ru.intodayer;

import java.time.LocalDate;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        LocalDate birthDay1 = LocalDate.of(1928, 12, 12);
        LocalDate deathDay1 = LocalDate.of(2008, 6, 10);

        LocalDate birthDay2 = LocalDate.of(1934, 11, 23);
        LocalDate deathDay2 = LocalDate.of(1996, 12, 20);

        LocalDate birthDay3 = LocalDate.of(1980, 2, 23);

        Author author1 = new Author("Чингиз Айтматов", birthDay1, deathDay1, Gender.MAN);
        Author author2 = new Author("Карл Саган", birthDay2, deathDay2, Gender.MAN);
        Author author3 = new Author("Дарья Данцова", birthDay3, Gender.WOMAN);

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        System.out.println(Analyzer.getAverageAuthorAge(authors));
        System.out.println(Analyzer.sortAuthorsByAge(authors));
        System.out.println(Analyzer.filterPensioners(authors));

        Book b1 = new Book("Буранный полустанок", birthDay1, author1, author2);
        Book b2 = new Book("Евлампия Романова", birthDay3, author3);
        Book b3 = new Book("Космос", birthDay3, author2);

        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        System.out.println(Analyzer.mapBookTitlesToAge(books));

        System.out.println(Analyzer.mapAuthorsToBooks(books));

        System.out.println(Analyzer.getCollaborativeAuthors(books));
    }
}
