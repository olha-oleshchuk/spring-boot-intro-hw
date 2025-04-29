package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.BookDto;
import mate.academy.dao.CreateBookRequestDto;
import mate.academy.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);
}
