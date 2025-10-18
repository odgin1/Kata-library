package md.kata.katalibrary.book.models;

import java.util.Set;

public record AuthorBooks(Author author, Set<Book> books) {
}
