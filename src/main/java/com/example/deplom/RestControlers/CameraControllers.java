package com.example.deplom.RestControlers;

import com.example.deplom.DTOS.CameraDTO;
import com.example.deplom.models.Camera;
import com.example.deplom.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera")
@RequiredArgsConstructor
public class CameraControllers {
    private CameraService cameraService;

    @Autowired
    public CameraControllers(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @PostMapping("/create-camera")
    public ResponseEntity<Camera> createCamera(@RequestBody CameraDTO cameraDTO) {
        cameraService.createCamera(cameraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete-camera/{id}")
    public void deleteCameraById(@PathVariable("id") Long id){
        cameraService.deleteCameraById(id);
    }

    @PutMapping("/update-camera/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody CameraDTO cameraDTO) {
        cameraService.updateCamera(id, cameraDTO);
    }

    @GetMapping("/get-all-camera")
    public List<CameraDTO> getAllCamera(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ){
        return cameraService.getAllCamera(PageRequest.of(page, size, Sort.by("brand")));
    }
}
