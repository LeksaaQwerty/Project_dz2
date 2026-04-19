import java.util.Objects;

public class Book implements Comparable<Book>{
    

    private final String name;
    private final int year;
    private final int str;

    public Book(String name, int year, int str) {
        this.name = name;
        this.year = year;
        this.str = str;
    }
    
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
    
    public int getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "Книга " + name + ", год выпуска " + year + ", " + str + " страниц(ы)";
    }

    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.str, book.str);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Book book = (Book) obj;
        return Objects.equals(this.name, book.name);
    } 
}