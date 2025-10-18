package md.kata.katalibrary.borrowing.model;

import java.util.UUID;

public record BookBorrow(UUID id, UUID bookId, UUID userId) {

}
