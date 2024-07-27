package com.example.relationships.service;

import com.example.relationships.dto.CategoryDto;
import com.example.relationships.model.Category;
import com.example.relationships.repository.CategoryRepository;
import com.example.relationships.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDto saveCategory(CategoryDto categoryDto){
        if (categoryDto.getName().equals(null)){
            throw new RuntimeException("not be null!");
        }

        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);

        //response

        return CategoryDto.builder()
                .name(categoryDto.getName()).build();
    }

    public List<Category> getAllCategory(Long id){
        return categoryRepository.findAllById(id);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepository.deleteById(id);
    }

}
