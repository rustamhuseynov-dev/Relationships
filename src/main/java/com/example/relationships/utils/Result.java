package com.example.relationships.utils;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result <T>{

    private T data;

    private boolean success = true;

    private String message;
}
