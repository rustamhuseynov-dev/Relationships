package com.example.relationships.controller;

import com.example.relationships.dto.CategoryDto;
import com.example.relationships.model.Category;
import com.example.relationships.service.CategoryService;
import com.example.relationships.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/save")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.saveCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}/get-all")
    public ResponseEntity<List<Category>> getAllCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.getAllCategory(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
