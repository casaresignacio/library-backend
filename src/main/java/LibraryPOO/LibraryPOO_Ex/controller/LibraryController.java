package LibraryPOO.LibraryPOO_Ex.controller;

import LibraryPOO.LibraryPOO_Ex.exception.BookNotFoundException;
import LibraryPOO.LibraryPOO_Ex.model.Book;
import LibraryPOO.LibraryPOO_Ex.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    //get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    //add a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book newBook) {
        return libraryService.saveBook(newBook);
    }

    //borrow a book
    @PostMapping("/{isbn}/borrow/{userId}")
    public Book borrowBook(@PathVariable String isbn, @PathVariable Long userId){
        return libraryService.borrowBook(isbn, userId);
    }

    //Handling Exception NOT FOUND
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundException.class)
    public Map<String, String> handleBookNotFound(BookNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }


}
