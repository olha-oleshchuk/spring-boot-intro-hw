package mate.academy.service;

import java.util.List;
import mate.academy.dao.BookDto;
import mate.academy.dao.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto getById(Long id);

    void update(Long id, BookDto bookDto);

    void delete(Long id);
}
