package com.example.deplom.service;

import com.example.deplom.DTOS.LensDTO;
import com.example.deplom.models.Camera;
import com.example.deplom.models.Lens;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface LensService {
    void createLens(LensDTO lensDTO);
    LensDTO findLensById(Long id);
    void deleteLensById(Long id);
    void updateLens(Long Id, LensDTO lensDTO);
    List<LensDTO> getAllLens(PageRequest pageRequest);
    public List<Lens> findLensByBayonet(String bayonet);

}
