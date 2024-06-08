package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.LensDTO;
import com.example.deplom.mappers.LensMapper;
import com.example.deplom.models.Lens;
import com.example.deplom.repository.LensRepository;
import com.example.deplom.service.LensService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LensServiceImpl implements LensService {
    private final LensRepository lensRepository;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    @Override
    public void createLens(LensDTO lensDTO) {
        Lens lens = LensMapper.INSTANCE.toModel(lensDTO);
        lensRepository.save(lens);
    }

    @Override
    public LensDTO findLensById(Long id) {
        Lens lens = lensRepository.getLensById(id);
        return LensMapper.INSTANCE.toDTO(lens);
    }

    @Override
    public void deleteLensById(Long id) {
        lensRepository.deleteById(id);
    }

    @Override
    public void updateLens(Long Id, LensDTO lensDTO) {
        Optional<Lens> lensOptional = lensRepository.findById(Id);
        Lens lens = lensOptional.orElseThrow(() -> new NotFoundException("Not found lens by id" + Id));
        lens.setBayonet(lensDTO.getBayonet());
        lens.setFocalLength(lensDTO.getFocalLength());
        lens.setLensType(lensDTO.getLensType());
        lens.setFocus(lensDTO.getFocus());
        lens.setManufacturers(lensDTO.getManufacturers());
        lens.setDirection(lensDTO.getDirection());
        lens.setMatrixFormat(lensDTO.getMatrixFormat());
        lens.setWeight(lensDTO.getWeight());
        lens.setPrice(lensDTO.getPrice());

        lensRepository.save(lens);
    }

    @Override
    public List<LensDTO> getAllLens(PageRequest pageRequest) {
        List<Lens> lens = lensRepository.findAll(pageRequest).getContent();
        return lens.stream().map(LensMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<Lens> findLensByBayonet(String bayonet) {
        return lensRepository.findByBayonet(bayonet);
    }
}
