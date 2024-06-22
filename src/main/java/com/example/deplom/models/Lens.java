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
    private String bayonet;
    private String focalLength;
    private String lensType;
    private String focus;
    private String manufacturers;
    private String direction;
    private String matrixFormat;
    private String weight;
    private double price;
}
