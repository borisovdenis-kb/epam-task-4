package ru.intodayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*;


public class Analyzer {
    private static <T> boolean collectionIsEmpty(Collection<T> collection) {
        return (collection == null && collection.isEmpty());
    }

    public static Double getAverageAuthorAge(Collection<Author> authors) {
        if (collectionIsEmpty(authors))
            return null;
        return authors.stream().collect(Collectors.averagingInt(Author::getAge));
    }

    public static List<Author> sortAuthorsByAge(Collection<Author> authors) {
        if (collectionIsEmpty(authors))
            return null;
        return authors
                .stream()
                .sorted(Comparator.comparing(Author::getAge))
                .collect(Collectors.toList());
    }

    public static List<Author> filterPensioners(Collection<Author> authors) {
        if (collectionIsEmpty(authors))
            return null;

        Predicate<Author> siftYoung = (a) -> {
            int age = a.getAge();
            return  (a.getGender() == Gender.MAN ? age > 65 : age > 63);
        };
        return authors.stream().filter(siftYoung).collect(Collectors.toList());
    }

    public static Map<String, Integer> mapBookTitlesToAge(Collection<Book> books) {
        if (collectionIsEmpty(books))
            return null;

        return books
            .stream().collect(Collectors.toMap(
                (book) -> book.getTitle(),
                (book) -> (int) ChronoUnit.YEARS.between(book.getPublishDate(), LocalDate.now())
            ));
    }

    public static List<Author> getCollaborativeAuthors(Collection<Book> books) {
        if (collectionIsEmpty(books))
            return null;

        return books
            .stream()
            .filter((book) -> book.getAuthors().size() > 1)
            .flatMap(book -> book.getAuthors().stream())
            .distinct()
            .collect(Collectors.toList());
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
        if (collectionIsEmpty(books))
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

    public static void demonstrateWorkOfAnalyzer() {
        List<Author> authors = TestDataCreator.createAuthorList();
        List<Book> books = TestDataCreator.createBookList(authors);

        System.out.println("Average age of authors:        " + Analyzer.getAverageAuthorAge(authors));
        System.out.println("Books and their ages:          " + Analyzer.mapBookTitlesToAge(books));
        System.out.println("Pensioners:                    " + Analyzer.filterPensioners(authors));
        System.out.println("Authors and their books:       " + Analyzer.mapAuthorsToBooks(books));
        System.out.println("Sorting authors by age (asc.): " + Analyzer.sortAuthorsByAge(authors));
        System.out.println("List of collaborative authors: " + Analyzer.getCollaborativeAuthors(books));
    }
}
