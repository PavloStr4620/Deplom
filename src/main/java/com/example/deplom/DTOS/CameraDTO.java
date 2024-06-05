package com.example.deplom.DTOS;

import lombok.Data;


@Data
public class CameraDTO {
    private String brand; // Бренд
    private String model; // Модель
    private String matrix; // Матриця
    private String shootingFeatures;
    private String video; // Рошиверння відео
    private String cameraWeight; // Вага
    private String multiplicityOfIncrease; // Фокусування
    private String displayDiagonal; // Діагональ дисплея
    private double price; // Ціна
}
