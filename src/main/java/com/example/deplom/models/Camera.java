package com.example.deplom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;
    private String brand; // Бренд
    private String model; // Модель
    private String matrix; // Матриця
    private double display; // Дисплей
    private String video; // Рошиверння відео
    private int cameraWeight; // Вага
    private String focusing; // Фокусування
    private String displayDiagonal; // Діагональ дисплея
    private double price; // Ціна
}
