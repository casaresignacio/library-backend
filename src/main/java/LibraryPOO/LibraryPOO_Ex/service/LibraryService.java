package LibraryPOO.LibraryPOO_Ex.service;

import LibraryPOO.LibraryPOO_Ex.exception.BookAlreadyBorrowedException;
import LibraryPOO.LibraryPOO_Ex.exception.BookNotFoundException;
import LibraryPOO.LibraryPOO_Ex.model.Book;
import LibraryPOO.LibraryPOO_Ex.repository.BookRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book borrowBook(String isbn, Long userId) {
        // check, verify state, update and save
        Book book = bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + isbn + " not found."));

        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("This book is already borrowed.");
        }

        book.setBorrowed(true);
        return bookRepository.save(book);

    }


}
