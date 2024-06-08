package com.example.deplom.service;

import com.example.deplom.DTOS.TripodDTO;
import com.example.deplom.models.Lens;
import com.example.deplom.models.Tripod;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TripodService {
    void createTripod(TripodDTO tripodDTO);
    TripodDTO findTripodById(Long id);
    void deleteTripodById(Long id);
    void updateTripod(Long id, TripodDTO tripodDTO);
    List<TripodDTO> getAllTripod(PageRequest pageRequest);
    public List<Tripod> findTripodByType(String type);

}
