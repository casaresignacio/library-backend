package LibraryPOO.LibraryPOO_Ex.repository;

import LibraryPOO.LibraryPOO_Ex.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByAuthor(String author);


}
