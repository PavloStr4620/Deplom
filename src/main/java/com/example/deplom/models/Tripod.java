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
@Table(name = "tripods")
public class Tripod {
    @Id
    private Long id;
    private String type; // Тип
    private String head; // Головка
    private String dimensions; // Розміри (від ? до ?)
    private String material; // Матеріал
    private String legSection; // Секції ніжок
    private String headType; // Тип головки
}
