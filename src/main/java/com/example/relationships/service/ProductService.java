package com.example.relationships.service;

import com.example.relationships.dto.CategoryDto;
import com.example.relationships.dto.ProductDto;
import com.example.relationships.model.Category;
import com.example.relationships.model.Product;
import com.example.relationships.repository.ProductRepository;
import com.example.relationships.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public ProductDto saveProduct(ProductDto productDto){

        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        productRepository.save(product);
        return ProductDto.builder()
                .price(productDto.getPrice())
                .title(productDto.getTitle())
                .category(productDto.getCategory())
                .build();
    }

    public List<Product> getAllProduct(Long id){
        return productRepository.findAllById(id);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        productRepository.deleteById(id);
    }
}
