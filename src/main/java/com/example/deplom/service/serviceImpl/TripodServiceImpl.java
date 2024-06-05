package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.TripodDTO;
import com.example.deplom.mappers.TripodMapper;
import com.example.deplom.models.Tripod;
import com.example.deplom.repository.TripodRepository;
import com.example.deplom.service.TripodService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripodServiceImpl implements TripodService {
    private final TripodRepository tripodRepository;

    @Autowired
    public TripodServiceImpl(TripodRepository tripodRepository) {
        this.tripodRepository = tripodRepository;
    }

    @Override
    public void createTripod(TripodDTO tripodDTO) {
        Tripod tripod = TripodMapper.INSTANCE.toModel(tripodDTO);
        tripodRepository.save(tripod);
    }

    @Override
    public TripodDTO findTripodById(Long id) {
        Tripod tripod = tripodRepository.getTripodById(id);
        return TripodMapper.INSTANCE.toDTO(tripod);
    }

    @Override
    public void deleteTripodById(Long id) {
        tripodRepository.deleteById(id);
    }

    @Override
    public void updateTripod(Long id, TripodDTO tripodDTO) {
        Optional<Tripod> tripodOptional = tripodRepository.findById(id);
        Tripod tripod = tripodOptional.orElseThrow(() -> new NotFoundException("Not found tripod by id" + id));
        tripod.setType(tripodDTO.getType());
        tripod.setHead(tripodDTO.getHead());
        tripod.setDimensions(tripodDTO.getDimensions());
        tripod.setMaterial(tripodDTO.getMaterial());
        tripod.setLegSection(tripodDTO.getLegSection());
        tripod.setHeadType(tripodDTO.getHeadType());

        tripodRepository.save(tripod);
    }

    @Override
    public List<TripodDTO> getAllTripod(PageRequest pageRequest) {
        List<Tripod> tripods = tripodRepository.findAll(pageRequest).getContent();
        return tripods.stream().map(TripodMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

}
