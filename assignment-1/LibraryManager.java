// package librarymanagement;

// You will create a Library Book Management System in Java. 
// This program allows users to manage book records using classes, loops, arrays/ArrayLists, and control statements. 
// You will use encapsulation to protect book information and loops/conditionals for user interaction.

// Requirements

// Create a Book class (Encapsulation & Advanced Class Components)
// Private fields: title (String), author (String), isbn (String), available (boolean)
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    // Default constructor and parameterized constructor
    // Default constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.available = true;
    }

    // Parameterized constructor
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    // Getters and setters with validation
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        // title should not be null or empty
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        // author should not be null or empty
        if (author != null && !author.isEmpty()) {
            this.author = author;
        }
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        // isbn must follow a simple pattern (e.g., 10 or 13 characters)
        if (isbn != null && (isbn.length() == 10 || isbn.length() == 13)) {
            this.isbn = isbn;
        }
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    // displayInfo() method to print book details
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + (available ? "Available" : "Checked Out"));
    }
}
    


// 2. Main Program — LibraryManager.java

// Use an ArrayList to store multiple Book objects
// Provide a menu-driven interface for the user:
// 1.  Add a new book

// 2. Display all books

// 3. Display all available books

// 4. Search books by author

// 5. Check out a book (set available to false)

// 6. Return a book (set available to true)

// 7. Exit

// 3. Menu Functionality (Control & Iteration)

// Use loops to continuously show the menu until the user chooses Exit
// Use if-else or switch to handle menu options
// Validate all user input using loops and conditionals
// 4. Additional Features (Arrays & ArrayLists)

// When displaying books, show the count of available vs checked-out books
// Optional: Sort the ArrayList by title before displaying


public class LibraryManager {

    public LibraryManager() {
    }
    
}
