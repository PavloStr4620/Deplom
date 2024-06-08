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
@Table(name = "lens")
public class Lens {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String bayonet; // Байонет
    private String focalLength; // Фокусна відстань
    private String lensType; // Тип Обєктива
    private String focus; // Фокусування
    private String manufacturers; // Виробники
    private String direction; // Напрямок
    private String matrixFormat; // Формат матриці
    private String weight; // Вага
    private double price; // Ціна
}
