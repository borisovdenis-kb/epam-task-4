package ru.intodayer;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*;


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
        if (authors == null || authors.isEmpty())
            return null;
        // считаю разницу между датой рождения и сегодняшней датой. правильно ли это?
        Predicate<Author> siftYoung = (a) -> {
            int years = (int) ChronoUnit.YEARS.between(a.getBirthDay(), LocalDate.now());
            return  (a.getGender() == Gender.MAN ? years > 65 : years > 63);
        };
        return authors.stream().filter(siftYoung).collect(Collectors.toList());
    }

    public static Map<String, Integer> mapBookTitlesToAge(Collection<Book> books) {
        if (books == null || books.isEmpty())
            return null;
        Map<String, Integer> pairs = new HashMap<>();
        books
            .stream().forEach((b) -> {
                int years = (int) ChronoUnit.YEARS.between(b.getPublishDate(), LocalDate.now());
                pairs.put(b.getTitle(), years);
            });
        return pairs;
    }

    public static List<Author> getCollaborativeAuthors(Collection<Book> books) {
        List<Author> collaborative = new ArrayList<>();
        books
            .stream()
            .filter((b) -> b.getAuthors().size() > 1)
            .forEach((b) -> {
                b.getAuthors()
                    .stream().forEach((a) -> {
                        if (!collaborative.contains(a)) {
                            collaborative.add(a);
                        }
                });
            });
        return collaborative;
    }

    private static void addBookToAuthor(Map<String, HashSet<String>> pairs, String key, String value) {
        HashSet<String> set = new HashSet<>();

        if (pairs.containsKey(key)) {
            pairs.get(key).add(value);
        } else {
            set.add(value);
            pairs.put(key, set);
        }
    }

    public static Map<String, HashSet<String>> mapAuthorsToBooks(Collection<Book> books) {
        if (books == null || books.isEmpty())
            return null;
        Map<String, HashSet<String>> pairs = new HashMap<>();
        books
            .stream().forEach((b) -> {
                b.getAuthors()
                    .stream().forEach((a) -> {
                        addBookToAuthor(pairs, a.getName(), b.getTitle());
                    });
            });
        return pairs;
    }
}
