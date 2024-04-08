package com.example.deplom.DTOS;

import lombok.Data;

@Data
public class CameraDTO {
    private Long id;
    private String name;
    private String model;
    private String display;
    private String video;
    private double price;
}
