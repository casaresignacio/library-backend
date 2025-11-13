package LibraryPOO.LibraryPOO_Ex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed = false;

    
}
