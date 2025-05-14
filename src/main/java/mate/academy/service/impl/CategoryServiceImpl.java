package mate.academy.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.dao.CategoryDto;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.model.Сategory;
import mate.academy.repository.CategoryRepository;
import mate.academy.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryRepository categoryMapper;

    @Override
    public List findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(categoryMapper::toDto);
    }

    @Override
    public CategoryDto getById(Long id) {
        Сategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Canʼt find book by id " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
