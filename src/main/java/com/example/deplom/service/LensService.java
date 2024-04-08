package com.example.deplom.service;

import com.example.deplom.DTOS.LensDTO;

public interface LensService {
    public void createLens(LensDTO lensDTO);
    void update(LensDTO lensDTO);
}
