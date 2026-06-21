class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LMS {
    public static void main(String[] args) {

        Book[] books = {
            new Book(101, "C Programming", "Dennis Ritchie"),
            new Book(102, "Data Structures", "Mark Allen"),
            new Book(103, "Java Programming", "James Gosling"),
            new Book(104, "Python Basics", "Guido Van Rossum"),
            new Book(105, "Web Development", "John Duckett")
        };

        String searchTitle = "Java Programming";

        boolean found = false;

        System.out.println("Linear Search:");

        for(int i = 0; i < books.length; i++) {
            if(books[i].title.equals(searchTitle)) {
                System.out.println("Book Found");
                System.out.println("Book ID: " + books[i].bookId);
                System.out.println("Title: " + books[i].title);
                System.out.println("Author: " + books[i].author);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Book Not Found");
        }

        System.out.println("\nBinary Search:");

        int low = 0;
        int high = books.length - 1;
        found = false;

        while(low <= high) {

            int mid = (low + high) / 2;

            int result = searchTitle.compareTo(books[mid].title);

            if(result == 0) {

                System.out.println("Book Found");
                System.out.println("Book ID: " + books[mid].bookId);
                System.out.println("Title: " + books[mid].title);
                System.out.println("Author: " + books[mid].author);

                found = true;
                break;
            }

            if(result > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if(!found) {
            System.out.println("Book Not Found");
        }
    }
}