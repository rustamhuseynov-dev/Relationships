package com.example.relationships.dto;

import com.example.relationships.model.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String title;

    private Double price;

    private Category category;
}
