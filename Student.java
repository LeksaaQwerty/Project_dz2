import java.util.ArrayList;
import java.util.List;

public class Student {
    

    private List<Book> books = new ArrayList<>();
    private final String nameStudent;

    public Student(String nameStudent, List<Book> books) {
        this.nameStudent = nameStudent;
        this.books = books;
    }
    

    public List<Book> getBooks() {
        return books;
    }    

    public String getNameStudent() {
        return nameStudent;
    }

    @Override
    public String toString() {
        return nameStudent;
    }

}
