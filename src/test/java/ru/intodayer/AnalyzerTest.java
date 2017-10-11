package ru.intodayer;

import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class AnalyzerTest extends TestCase {
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();


    public void setUp() throws Exception {
        this.authors = CreateTestData.createAuthorList();
        this.books = CreateTestData.createBookList(authors);
    }

    @Test
    public void testGetAverageAuthorAge() {
        double avgAge = Analyzer.getAverageAuthorAge(authors);
        assertEquals(70, avgAge);
    }

    public void testSortAuthorsByAge() {
    }

    public void testFilterPensioners() {
    }

    public void testMapBookTitlesToAge() {
    }

    public void testGetCollaborativeAuthors() {
    }

    public void testMapAuthorsToBooks() {
    }
}