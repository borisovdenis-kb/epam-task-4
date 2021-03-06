package ru.intodayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class Book {
    private final String title;
    private final LocalDate publishDate;
    private final ArrayList<Author> authors = new ArrayList<>();

    public Book(String title, LocalDate publishDate, Author... authors) {
        this.title = title;
        this.publishDate = publishDate;
        Collections.addAll(this.authors, authors);
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
