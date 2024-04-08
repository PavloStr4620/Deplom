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
@Table(name = "lens")
public class Lens {
    @Id
    private Long id;
    private String bayonet; // Байонет
    private int focalLength; // Фокусна відстань
    private String system; // Система
    private String focus; // Фокусування
    private String aperture; // Діафрагма
    private String viewingAngle; // Кут огляду
    private String matrixSize; // Розмір матриці
    private int weight; // Вага
    private double price; // Ціна
}
