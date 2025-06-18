import java.util.Scanner;

class Book {
    String Title;
    String Author;
    Boolean Status;
    String BookType;

    public Book(String Title, String Author, Boolean Status, String BookType) {
        this.Title = Title;
        this.Author = Author;
        this.Status = Status;
        this.BookType = BookType;
    }
}

abstract class Users {
    int maxbook;
    int currbook;

    public Users(int maxbook, int currbook) {
        this.maxbook = maxbook;
        this.currbook = currbook;
    }

    abstract void borrowBooks(Book b);
    abstract void returnBooks(Book b, int days);
}

class Student extends Users {
    public Student() {
        super(2, 0);
    }

    @Override
    public void borrowBooks(Book b) {
        if (b.Status && currbook < maxbook) {
            b.Status = false;
            System.out.println("Book borrowed: " + b.Title);
            currbook++;
        } else {
            System.out.println("Cannot borrow. Book may be unavailable or limit reached.");
        }
    }

    @Override
    public void returnBooks(Book b, int days) {
        if (currbook > 0) {
            b.Status = true;
            double fine = b.BookType.equalsIgnoreCase("E-Books") ? 0 : 5 * days * 0.5;
            System.out.println("Book returned. Fine charged: " + fine);
            currbook--;
        } else {
            System.out.println("No books to return.");
        }
    }
}

class Teacher extends Users {
    public Teacher() {
        super(3, 0);
    }

    @Override
    public void borrowBooks(Book b) {
        if (b.Status && currbook < maxbook) {
            b.Status = false;
            System.out.println("Book borrowed: " + b.Title);
            currbook++;
        } else {
            System.out.println("Cannot borrow. Book may be unavailable or limit reached.");
        }
    }

    @Override
    public void returnBooks(Book b, int days) {
        if (currbook > 0) {
            b.Status = true;
            System.out.println("Book returned. Teachers don’t pay fines.");
            currbook--;
        } else {
            System.out.println("No books to return.");
        }
    }
}

class Library
{
    Book[] bArr = new Book[10];
    int count = 0;

    public void Addbook(Book b)
    {
        if (count < bArr.length)
        {
            bArr[count++] = b;
            System.out.println("Book added: " + b.Title);
        }
        else
        {
            System.out.println("Library full. Cannot add more books.");
        }
    }

    public Book Searchbook(String title)
    {
        for (int i = 0; i < count; i++)
        {
            if (bArr[i].Title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + bArr[i].Title);

                return bArr[i];
            }
        }
        System.out.println("Book not found.");
        return null;
    }
}

public class LibraryManagement {
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        Library l = new Library();

        System.out.println("Enter number of books to add:");
        int n = stdin.nextInt();
        stdin.nextLine(); // consume newline

        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter book name:");
            String Title = stdin.nextLine();

            System.out.println("Enter author name:");
            String Author = stdin.nextLine();

            System.out.println("Enter book status (true for available / false for borrowed):");
            Boolean Status = stdin.nextBoolean();
            stdin.nextLine(); // consume newline

            System.out.println("Enter book type (Printed / E-Books):");
            String BookType = stdin.nextLine();

            Book b = new Book(Title, Author, Status, BookType);
            l.Addbook(b);
        }

        System.out.println("Enter a book name to borrow:");
        String borrowTitle = stdin.nextLine();
        Book b1 = l.Searchbook(borrowTitle);

        if (b1 != null)
        {
            Users st = new Student();
            st.borrowBooks(b1);

            System.out.println("Enter number of days before returning:");
            int days = stdin.nextInt();
            st.returnBooks(b1, days);
        }
    }
}
