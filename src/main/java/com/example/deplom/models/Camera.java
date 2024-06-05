package com.example.deplom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "camera")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String brand; // Бренд
    private String model; // Модель
    private String matrix; // Матриця
    private String shootingFeatures; // Зйомка та функції
    private String video; // Рошиверння відео
    private String cameraWeight; // Вага
    private String multiplicityOfIncrease; // Кратність збільшення
    private String displayDiagonal; // Діагональ дисплея
    private double price; // Ціна

}
