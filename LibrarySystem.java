import java.util.*;

public class LibrarySystem {
    private static Map<String, Boolean> books = new HashMap<>();

    // Invariant: A book can only be borrowed if available
    static {
        books.put("B001", true);
        books.put("B002", true);
    }

    public static void borrowBook(String bookId) {
        assert books.containsKey(bookId) : "Pre-condition failed: Book must exist.";
        assert books.get(bookId) : "Pre-condition failed: Book must be available.";

        books.put(bookId, false); // Process

        assert !books.get(bookId) : "Post-condition failed: Book must be marked as borrowed.";
    }

    public static void main(String[] args) {
        borrowBook("B001");
        System.out.println("Borrowed B001 successfully.");

        borrowBook("B001"); // Should trigger assertion
    }
}
