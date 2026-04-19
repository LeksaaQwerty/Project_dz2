import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{


    public static void main(String[] args){


        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            
            String line;

            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");

                String name = parts[0];

                List<Book> books = new ArrayList<>();

                    for (int i = 1; i < parts.length; i++) {
                        String[] bookParts = parts[i].split(":");
                        
                        books.add(new Book(bookParts[0], Integer.parseInt(bookParts[1]), Integer.parseInt(bookParts[2])));
                    }

                students.add(new Student(name, books));
            
            }

        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        
        //System.out.println(students.toString());

        students.stream()
            .peek(System.out::println)
            .map(Student::getBooks) 
            .flatMap(List::stream)
            .sorted()
            .distinct()
            .filter(book -> book.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .ifPresentOrElse(year -> System.out.println("Год: " + year), () -> System.out.println("Книга не найдена"));

    }
}



