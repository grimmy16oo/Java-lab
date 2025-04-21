

class Book {

    String title, author;
    boolean isAvailable;
    String type;

    Book(String title, String author, String type) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.type = type;
    }
}

class User {

    String name;
    int maxBooks;

    Book[] borrowedBooks;
    int borrowedCount;

    User(String name, int maxBooks) 
    {
        this.name = name;
        this.maxBooks = maxBooks;
        
        this.borrowedBooks = new Book[maxBooks];
        this.borrowedCount = 0;
    }

    boolean borrow(Book book) 
    {
        if (book.isAvailable && borrowedCount < maxBooks) 
        {
            book.isAvailable = false;
            borrowedBooks[borrowedCount++] = book;
            return true;
        }
        return false;
    }

    void returnBook(Book book, int lateDays) 
    {
        for (int i = 0; i < borrowedCount; i++) 
        {
            if (borrowedBooks[i] == book) 
            {
                borrowedBooks[i] = borrowedBooks[--borrowedCount];
                book.isAvailable = true;

                int fine = 0;
                if (book.type.equals("Printed") && lateDays > 0) 
                {
                    fine = lateDays * 5;
                    if (this instanceof Student) {
                        fine /= 2;
                    }
                }
                System.out.println(name + " Fine: " + (this instanceof Teacher ? 0 : fine) + " Tk.");
                return;
            }
        }
    }
}

class Student extends User {

    Student(String name) {
        super(name, 2);
    }
}

class Teacher extends User {

    Teacher(String name) {
        super(name, 3);
    }
}

class Library {

    Book[] books = new Book[100];
    int bookCount = 0;

    void addBook(Book book) {
        books[bookCount++] = book;
    }

    Book searchBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) 
    {
        Library l = new Library();

        l.addBook(new Book("Java", "Gosling", "Printed"));
        l.addBook(new Book("Python", "Guido", "E-Book"));

        User stu = new Student("Alice");
        User teach = new Teacher("Bob");

        Book book = l.searchBook("Java");
        if (book != null && stu.borrow(book)) 
        {
            System.out.println("Borrowed: " + book.title);
        }
        stu.returnBook(book, 3);
    }
}



// class Book {

//     private String Title;
//     private String Author;
//     private boolean status;
//     private String Book_type;

//     public Book(String t, String a, String type) {
//         Title = t;
//         Author = a;
//         status = true;
//         Book_type = type;
//     }
// }

// abstract class User {

//     private int amount;

//     public User(int a) {
//         amount = a;
//     }

//     abstract double calculateFine(int lateDays, String bookType);
// }

// class Students extends User {

//     public Students(String name) {
//         super(name, 2);
//     }

//     double calculateFine(int lateDays, String bookType) {
//         if (bookType.equals("Printed")) 
//             return lateDays * 2.5;
//          else 
//             return 0;
        
//     }
// }

// class Teacher extends User {

//     public Teacher(String name) {
//         super(name, 3);
//     }

//     double calculateFine(int lateDays, String bookType) {
//         return 0;
//     }
// }

// class Library {

//     Book[] books = new Book[10]; // Array to store books
//     int cnt = 0;

//     void addBook(Book b) {
//         if (cnt < books.length) {
//             books[cnt++] = b;
//             System.out.println("Book added!");
//         } else {
//             System.out.println("Library is full!");
//         }
//     }

//     Book searchBook(String t) {
//         for (int i = 0; i < books.length; i++) {
//             if (books[i].Title.equals(t)) {
//                 return books[i];
//             }
//         }
//         return null;
//     }

//     void borrowBook(User u, String t) {
//         if (u.cnt >= u.bookNum) {
//             System.out.println("Book limit reached!");
//             return ;
//         }
//     }

// }

// public class LibraryManagementSystem {

//     public static void main(String[] args) {
//         Library library = new Library();
//         library.addBook(new Book("Java Programming", "James Gosling", "Printed"));
//         library.addBook(new Book("Data Structures", "Mark Weiss", "E-Book"));

//         Students student = new Students("Alice");
//         Teacher teacher = new Teacher("Mr. Smith");

//         library.borrowBook(student, "Java Programming");

//     }
// }
