
import java.util.Scanner;

class Book {

    String title;
    String author;
    boolean status;
    String type;

    public Book(String title, String author, boolean status, String type) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.type = type;
    }

    boolean getStatus() {
        return status;
    }
}

abstract class User {

    int maxBook;
    int currentCount = 0;

    public User(int maxBook) 
    {
        this.maxBook = maxBook;
    }

    abstract void borrowBook(Book b);
    abstract void returnBook(Book b, int days);
}

class Student extends User {

    public Student() {
        super(2);
    }

    @Override
    void borrowBook(Book b) 
    {
        if (b.getStatus() && currentCount < maxBook) 
        {
            b.status = false; // book borrowed. cant borrow the same book anymore
            currentCount++;

            System.out.println("Student borrowed: " + b.title);
        } 
        else 
        {
            System.out.println("Cannot borrow the book.");
        }
    }

    @Override
    void returnBook(Book b, int days) 
    {
        b.status = true; // book returned. can borrow the same book
        currentCount--;

        if (b.type.equalsIgnoreCase("Printed") && days > 0) 
        {
            int fine = (5 * days) / 2;
            System.out.println("Fine for student: " + fine + " Tk");
        } 
        else 
        {
            System.out.println("No fine.");
        }
    }
}

class Teacher extends User {

    public Teacher() {
        super(3);
    }

    @Override
    void borrowBook(Book b) 
    {
        if (b.getStatus() && currentCount < maxBook) 
        {
            b.status = false;
            currentCount++;

            System.out.println("Teacher borrowed: " + b.title);
        } 
        else 
        {
            System.out.println("Cannot borrow the book.");
        }
    }

    @Override
    void returnBook(Book b, int days) 
    {
        b.status = true;
        currentCount--;

        System.out.println("No fine for teacher.");
    }
}

class Library {

    Book[] books = new Book[10];
    int i = 0;

    public void addBook(Book b) 
    {
        if (i < books.length) 
        {
            books[i++] = b;
            System.out.println("Book added: " + b.title);
        } 
        else 
        {
            System.out.println("Library is full.");
        }
    }

    public Book findBook(String title) 
    {
        for (Book b : books) {
            if (b != null && b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public void searchBook(String title) 
    {
        Book b = findBook(title);

        if (b != null) 
        {
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("Available: " + (b.status ? "Yes" : "No"));
        } 
        else {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryManagement 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Library lib = new Library();

        System.out.print("Enter number of books to add: ");
        int n = sc.nextInt();
        sc.nextLine();           // Fix to consume newline

        for (int i = 0; i < n; i++) 
        {
            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Title: ");
            String title = sc.nextLine();
    
            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Is it available (true/false)? ");
            boolean status = Boolean.parseBoolean(sc.nextLine());

            System.out.print("Type (Printed/E-book): ");
            String type = sc.nextLine();

            Book b1 = new Book(title, author, status, type);
            lib.addBook(b1);
        }

        User user = null;
        while (user == null) 
        {
            System.out.print("\nAre you a Student or Teacher? ");
            String userType = sc.nextLine();

            if (userType.equals("Teacher")) 
            {
                user = new Teacher();
            } 
            else if (userType.equals("Student")) 
            {
                user = new Student();
            } 
            else 
            {
                System.out.println("Invalid input. Please enter 'Student' or 'Teacher'.");
            }
        }

        while (true) 
        {
            System.out.println("\nChoose an option:");
            System.out.println("1. Borrow book");
            System.out.println("2. Return book");
            System.out.println("3. Search book");
            System.out.println("x. Exit");

            System.out.print("Your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("x")) 
            {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }

            switch (choice) 
            {
                case "1":
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = sc.nextLine();

                    Book b2 = lib.findBook(borrowTitle);

                    if (b2 != null) 
                    {
                        user.borrowBook(b2);
                    } 
                    else 
                    {
                        System.out.println("Book not found.");
                    }
                    break;

                case "2":
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();

                    Book r2 = lib.findBook(returnTitle);
                    
                    if (r2 != null) 
                    {
                        System.out.print("Enter number of late days: ");
                        int days = Integer.parseInt(sc.nextLine());
                        user.returnBook(r2, days);
                    } 
                    else
                    {
                        System.out.println("Book not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    lib.searchBook(searchTitle);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
