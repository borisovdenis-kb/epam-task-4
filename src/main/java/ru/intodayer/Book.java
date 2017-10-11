package ru.intodayer;

import java.time.LocalDate;
import java.util.ArrayList;


public class Book {
    private final String title;
    private final LocalDate publishDate;
    private final ArrayList<Author> authors;

    public Book(String title, LocalDate publishDate, ArrayList<Author> authors) {
        this.title = title;
        this.publishDate = publishDate;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
}
