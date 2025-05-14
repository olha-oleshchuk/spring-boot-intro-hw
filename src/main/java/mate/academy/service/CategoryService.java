package mate.academy.service;

import mate.academy.dao.CategoryDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CategoryService {
    List findAll(Pageable pageable);

    CategoryDto getById(Long id);

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(Long id, CategoryDto categoryDto);

    void deleteById(Long id);
}
