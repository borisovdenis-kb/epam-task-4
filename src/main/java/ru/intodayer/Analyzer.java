package ru.intodayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Analyzer {
    public static Double getAverageAuthorAge(Collection<Author> authors) {
        if (authors == null || authors.isEmpty())
            return null;
        return authors.stream().mapToInt(Author::getAge).average().getAsDouble();
    }

    public static List<Author> sortAuthorsByAge(Collection<Author> authors) {
        if (authors == null || authors.isEmpty())
            return null;
        return authors
                .stream()
                .sorted(Comparator.comparing(Author::getAge))
                .collect(Collectors.toList());
    }

    public static List<Author> filterPensioners(Collection<Author> authors) {
        // считаю разницу между датой рождения и сегодняшней датой. правильно ли это?
        Predicate<Author> siftYoung = (a) -> {
            int years = (int) ChronoUnit.YEARS.between(a.getBirthDay(), LocalDate.now());
            return  (a.getGender() == Gender.MAN ? years > 65 : years > 63);
        };
        return authors
                .stream()
                .filter(siftYoung)
                .collect(Collectors.toList());
    }
}
