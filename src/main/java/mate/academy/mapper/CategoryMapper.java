package mate.academy.mapper;

import mate.academy.dao.CategoryDto;
import mate.academy.model.Category;

public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDTO);
}
