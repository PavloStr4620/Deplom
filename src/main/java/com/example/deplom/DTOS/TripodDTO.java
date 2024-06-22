package com.example.deplom.DTOS;

import lombok.Data;

@Data
public class TripodDTO {
    private String type; // Тип
    private String manufacturer; // Виробник
    private String head; // Головка
    private String dimensions; // Розміри (від ? до ?)
    private String material; // Матеріал
    private String legSection; // Секції ніжок
    private String headType; // Тип головки
    private double price; // Ціна

}
