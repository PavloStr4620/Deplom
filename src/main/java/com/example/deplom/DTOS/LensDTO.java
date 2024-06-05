package com.example.deplom.DTOS;

import lombok.Data;

@Data
public class LensDTO {
    private String bayonet; // Байонет
    private String focalLength; // Фокусна відстань
    private String lensType;
    private String focus; // Фокусування
    private String manufacturers; // Виробники
    private String direction;
    private String matrixFormat;
    private String weight; // Вага
    private double price; // Ціна
}
