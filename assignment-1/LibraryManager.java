
import java.util.ArrayList;
import java.util.Scanner;

// 2. Main Program — LibraryManager.java
public class LibraryManager {

    // library array list to store book objects
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
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void libraryDisplay(Scanner scanner, boolean displayAll, boolean displayAvailable, boolean displayByAuthor, boolean checkoutBook, boolean returnBook, boolean removeBook) {

        int bookCount = 0; // bookCount keeps track of result num of displayed books
        int bookID = 0; // bookID keeps track of EVERY book

        // case 2. Display all books
        if(displayAll == true) {
            for(Book book : library){
                bookID++;
                bookCount++;
                System.out.println("\n~~~~ Result #" + bookCount + " ID: " + bookID + " ~~~~");
                book.displayInfo();
                System.out.print("\n");
            }
            displayAll = false;
        } // end case 2

        // case 3. Display all available books
        if(displayAvailable == true) {
            for(Book book : library){
                bookID++;
                if(book.isAvailable()){
                    bookCount++;
                    System.out.println("\n~~~~ Result #" + bookCount + " ID: " + bookID + " ~~~~");
                    book.displayInfo();
                    System.out.print("\n");
                }
            }
            displayAvailable = false;
        } // end case 3

        // case 4. Search books by author
        if(displayByAuthor == true) {
            System.out.println("Enter author name:");
            String authorName = scanner.nextLine();
            for(Book book : library){ 
                bookID++;
                if(book.getAuthor().equalsIgnoreCase(authorName)){
                    bookCount++;
                    System.out.println("\n~~~~ Result #" + bookCount + " ID: " + bookID + " ~~~~");
                    book.displayInfo();
                    System.out.print("\n");
                }
            }
            displayByAuthor = false;
        } // end case 4
        
        // case 5. Check out a book (set available to false)
        if(checkoutBook == true) {
            System.out.println("Enter book ID to check out:");
            int checkoutID = 0;
            // try to get scanner input and parse to int, if a letter/invalid char is input, catch exception
            try {
                checkoutID = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                checkoutBook = false;
            }
            // validate book ID
            // make sure checkoutID isnt larger than the library size and isn't 0
            if(checkoutID > 0 && checkoutID <= library.size()) {
                Book bookToCheckout = library.get(checkoutID - 1);
                //set availbility to false if it can be checked out, otherwise tell user that book is already checked out
                if(bookToCheckout.isAvailable()) {
                    bookToCheckout.setAvailable(false);
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book is already checked out.");
                }
            } else {
                System.out.println("Invalid book ID.");
            }
            checkoutBook = false;
        } // end case 5

        // case 6. Return a book (set available to true)
        if(returnBook == true) {
            System.out.println("Enter book ID to return:");
            int returnID = 0;
            // try to get scanner input and parse to int, if a letter/invalid char is input, catch exception
            try {
                returnID = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                returnBook = false;
            }
            // validate book ID
            // make sure returnID isnt larger than the library size and isn't 0
            if(returnID > 0 && returnID <= library.size()) {
                Book bookToReturn = library.get(returnID - 1);
                //set availbility to true if it can be returned, otherwise tell user that book is already available
                if(!bookToReturn.isAvailable()) {
                    bookToReturn.setAvailable(true);
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }
            } else {
                System.out.println("Invalid book ID.");
            }
            returnBook = false;
        } // end case 6

        // case 7. Remove a book
        if(removeBook == true) {
            System.out.println("Enter book ID to remove:");
            int removeID = 0;
            // try to get scanner input and parse to int, if a letter/invalid char is input, catch exception
            try {
                removeID = Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                removeBook = false;
            }
            // validate book ID
            // make sure removeID isnt larger than the library size and isn't 0
            if(removeID > 0 && removeID <= library.size()) {
                Book bookToRemove = library.get(removeID - 1);
                //remove the book from the library
                library.remove(bookToRemove);
                System.out.println("Book removed successfully.");
            } else {
                System.out.println("Invalid book ID.");
            }
            removeBook = false;
        } // end case 7
        
    } // end of libraryDisplay method

    // menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
            System.out.println("7. Remove a book");
            System.out.println("8. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addBook(scanner);
                    break;
                case "2":
                    // display all books
                    libraryDisplay(scanner, true, false, false, false, false, false);
                    break;
                case "3":
                    // display available books
                    libraryDisplay(scanner, false, true, false, false, false, false);
                    break;
                case "4":
                    // search by author
                    libraryDisplay(scanner, false, false, true, false, false, false);
                    break;
                case "5":
                    // check out a book
                    libraryDisplay(scanner, false, false, false, true, false, false);
                    break;
                case "6":
                    // return a book
                    libraryDisplay(scanner, false, false, false, false, true, false);
                    break;
                case "7":
                    // remove a book
                    libraryDisplay(scanner, false, false, false, false, false, true);
                    break;
                case "8":
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 8.");
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


