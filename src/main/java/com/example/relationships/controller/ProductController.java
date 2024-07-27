package com.example.relationships.controller;

import com.example.relationships.dto.ProductDto;
import com.example.relationships.model.Product;
import com.example.relationships.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.getAllProduct(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
