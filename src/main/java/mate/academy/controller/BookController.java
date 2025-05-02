package mate.academy.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.BookDto;
import mate.academy.dao.CreateBookRequestDto;
import mate.academy.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookServise;

    @GetMapping
    public List<BookDto> getAll() {
        return bookServise.findAll();
    }

    @GetMapping("/id")
    public BookDto getBookById(@PathVariable Long id) {
        return bookServise.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookServise.save(bookDto);
    }
}
