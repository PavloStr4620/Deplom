package com.example.deplom.service.serviceImpl;

import com.example.deplom.DTOS.CameraDTO;
import com.example.deplom.mappers.CameraMapper;
import com.example.deplom.models.Camera;
import com.example.deplom.repository.CameraRepository;
import com.example.deplom.service.CameraService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CameraServiceImpl implements CameraService {

    private final CameraRepository cameraRepository;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void createCamera(CameraDTO cameraDTO) {
        Camera camera = CameraMapper.INSTANCE.toModel(cameraDTO);
        cameraRepository.save(camera);
    }

    @Override
    public CameraDTO findCameraById(Long id) {
        Camera camera = cameraRepository.getCameraById(id);
        return CameraMapper.INSTANCE.toDTO(camera);
    }

    @Override
    public void deleteCameraById(Long id) {
        cameraRepository.deleteById(id);
    }

    @Override
    public void updateCamera(Long Id, CameraDTO cameraDTO) {
        Optional<Camera> cameraOptional = cameraRepository.findById(Id);
        Camera camera = cameraOptional.orElseThrow(() -> new NotFoundException("Not found camera by id" + Id));
        camera.setBrand(cameraDTO.getBrand());
        camera.setModel(cameraDTO.getModel());
        camera.setMatrix(cameraDTO.getMatrix());
        camera.setShootingFeatures(cameraDTO.getShootingFeatures());
        camera.setVideo(cameraDTO.getVideo());
        camera.setCameraWeight(cameraDTO.getCameraWeight());
        camera.setMultiplicityOfIncrease(cameraDTO.getMultiplicityOfIncrease());
        camera.setDisplayDiagonal(cameraDTO.getDisplayDiagonal());
        camera.setPrice(cameraDTO.getPrice());

        cameraRepository.save(camera);
    }

    @Override
    public List<CameraDTO> getAllCamera(PageRequest pageRequest) {
        List<Camera> camera = cameraRepository.findAll(pageRequest).getContent();
        return camera.stream().map(CameraMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    public List<Camera> findCamerasByBrand(String brand) {
        return cameraRepository.findByBrand(brand);
    }

    @Override
    public List<Camera> getAllCamera() {
        return cameraRepository.findAll();
    }
}
