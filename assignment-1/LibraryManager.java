
import java.util.ArrayList;
import java.util.Scanner;

// 2. Main Program — LibraryManager.java
public class LibraryManager {

    // Use an ArrayList to store multiple Book objects
    static ArrayList<Book> library = new ArrayList<>();
    
    // add books to the library
    public static void addBook(Scanner scanner) {
        String title = "";
        String author = "";
        String isbn = "";
        boolean available = false;
        String availableInput = "";

        // title with validation
        System.out.println("Enter book title:");
        title = scanner.nextLine();
        while (title == null || title.isEmpty()) {
            System.out.println("Title cannot be empty. Enter book title:");
            title = scanner.nextLine();
        }

        // author with validation
        System.out.println("Enter book author:");
        author = scanner.nextLine();
        while (author == null || author.isEmpty()) {
            System.out.println("Author cannot be empty. Enter book author:");
            author = scanner.nextLine();
        }
        
        // isbn with validation
        System.out.println("Enter book ISBN:");
        isbn = scanner.nextLine();
        while (isbn == null || (isbn.length() != 10 && isbn.length() != 13)) {
            System.out.println("ISBN must be 10 or 13 characters. Enter book ISBN:");
            isbn = scanner.nextLine();
        }

        // availability with validation
        System.out.println("Is the book available? (true/false):");
        availableInput = scanner.nextLine();
        while (!availableInput.equalsIgnoreCase("true") && !availableInput.equalsIgnoreCase("false")) {
            System.out.println("Enter either true or false. Is the book available? (true/false):");
            availableInput = scanner.nextLine();
        }
        if (availableInput.equalsIgnoreCase("true")) {
            available = true;
        }

        // create book object and add to library array list
        library.add(new Book(title, author, isbn, available));

    } // end of addBook method

    // display books based on search and filters
    public static void libraryDisplay(Scanner scanner, boolean displayAll, boolean displayAvailable) {

        int bookCount = 0; // bookCount keeps track of result num of displayed books
        int bookID = 0; // bookID keeps track of EVERY book

        // case 2. Display all books
        if(displayAll == true) {
            for(Book book : library){
                bookID++;
                bookCount++;
                System.out.println("~~~~ Result #" + bookCount + " ID: " + bookID + " ~~~~\n");
                book.displayInfo();
            }
            displayAll = false;
        }

        // case 3. Display all available books
        if(displayAvailable == true) {
            for(Book book : library){
                if(book.isAvailable()){
                bookID++;
                bookCount++;
                System.out.println("~~~~ Result #" + bookCount + " ID: " + bookID + " ~~~~\n");
                book.displayInfo();
                }
            }
            displayAvailable = false;
        }
        // case 4. Search books by author

        // case 5. Check out a book (set available to false)

        // case 6. Return a book (set available to true)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // running controls the menu
        // displayAll runs the display all books for loop
        // displayAvailable runs the display all available books for loop
        boolean running = true;
        System.out.println("Display:");
        while (running) {
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Display all available books");
            System.out.println("4. Search books by author");
            System.out.println("5. Check out a book");
            System.out.println("6. Return a book");
            System.out.println("7. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addBook(scanner);
                    break;
                case "2":
                    // display all books
                    libraryDisplay(scanner, true, false);
                    break;
                case "3":
                    // display available books
                    libraryDisplay(scanner, false, true);
                    break;
                case "4":
                    // search by author
                    break;
                case "5":
                    // check out a book
                    break;
                case "6":
                    // return a book
                    break;
                case "7":
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 7.");
            } // end switch cases
        } // end while loop
        scanner.close();
    } // end of main method

} // end of LibraryManager class


// 3. Menu Functionality (Control & Iteration)

// Use loops to continuously show the menu until the user chooses Exit
// Use if-else or switch to handle menu options
// Validate all user input using loops and conditionals
// 4. Additional Features (Arrays & ArrayLists)
// When displaying books, show the count of available vs checked-out books
// Optional: Sort the ArrayList by title before displaying


