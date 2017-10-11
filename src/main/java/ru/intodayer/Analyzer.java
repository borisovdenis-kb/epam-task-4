package ru.intodayer;

import java.util.Collection;


public class Analyzer {
    public static Double getAverageAuthorAge(Collection<Author> authors) {
        if (authors == null || authors.isEmpty())
            return null;
        return authors.stream().mapToInt(Author::getAge).average().getAsDouble();
    }
}
