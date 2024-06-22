package com.example.deplom.controllers.product;

import com.example.deplom.models.Camera;
import com.example.deplom.repository.CameraRepository;
import com.example.deplom.service.CameraService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camera-page")
public class PageCameraControllers {
    private final CameraRepository cameraRepository;
    private final CameraService cameraService;

    public PageCameraControllers(CameraRepository cameraRepository, CameraService cameraService) {
        this.cameraRepository = cameraRepository;
        this.cameraService = cameraService;
    }

    @GetMapping
    public String displayingCamerasPage(Model model,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Camera> camera = cameraRepository.findAll(pageable);

        model.addAttribute("camera", camera);
        return "Product/Camera/cameraPage";
    }

    @GetMapping("/page-camera-id/{id}")
    public String creatingProductPageCamera(Model model, @PathVariable("id") Long id) {
        Optional<Camera> camera_id = cameraRepository.findById(id);
        model.addAttribute("camera_id", camera_id);
        return "Product/Camera/productPageCamera";
    }

    @GetMapping("/page-create-camera")
    public String pageCreateCamera() {
        return "Product/Camera/pageAddCamera";
    }

    @PostMapping("/page-create-camera")
    public String pageAddCamera(@RequestParam String brand,
                                @RequestParam String model,
                                @RequestParam String matrix,
                                @RequestParam String shootingFeatures,
                                @RequestParam String video,
                                @RequestParam String cameraWeight,
                                @RequestParam String multiplicityOfIncrease,
                                @RequestParam String displayDiagonal,
                                @RequestParam double price
    ) {

        Camera camera = new Camera();
        camera.setBrand(brand);
        camera.setModel(model);
        camera.setMatrix(matrix);
        camera.setShootingFeatures(shootingFeatures);
        camera.setVideo(video);
        camera.setCameraWeight(cameraWeight);
        camera.setMultiplicityOfIncrease(multiplicityOfIncrease);
        camera.setDisplayDiagonal(displayDiagonal);
        camera.setPrice(price);

        cameraRepository.save(camera);
        return "redirect:/camera-page";
    }

    @GetMapping("/page-update-camera")
    public String pageUpdateCamera(@RequestParam("id") Long id, Model model) {
        Optional<Camera> camera_id = cameraRepository.findById(id);
        model.addAttribute("camera_id", camera_id);
        return "Product/Camera/pageUpdateCamera";
    }

    @PostMapping("/page-update-camera")
    public String pageUpdateCamera(@RequestParam("id") Long id,
                                   @RequestParam String brand,
                                   @RequestParam String model,
                                   @RequestParam String matrix,
                                   @RequestParam String shootingFeatures,
                                   @RequestParam String video,
                                   @RequestParam String cameraWeight,
                                   @RequestParam String multiplicityOfIncrease,
                                   @RequestParam String displayDiagonal,
                                   @RequestParam double price
    ) {
        Optional<Camera> cameraOptional = cameraRepository.findById(id);
        Camera camera = cameraOptional.orElseThrow(() -> new NotFoundException("Not found camera by id" + id));

        camera.setBrand(brand);
        camera.setModel(model);
        camera.setMatrix(matrix);
        camera.setShootingFeatures(shootingFeatures);
        camera.setVideo(video);
        camera.setCameraWeight(cameraWeight);
        camera.setMultiplicityOfIncrease(multiplicityOfIncrease);
        camera.setDisplayDiagonal(displayDiagonal);
        camera.setPrice(price);

        cameraRepository.save(camera);
        return "redirect:/camera-page";
    }

    @GetMapping("/delete-camera")
    public String deleteCameraById(@RequestParam("id") Long id) {
        cameraService.deleteCameraById(id);
        return "redirect:/camera-page";
    }

    @GetMapping("/search-camera")
    public String searchCamera(@RequestParam("brand") String brand, Model model) {
        List<Camera> search_camera = cameraService.findCamerasByBrand(brand);
        model.addAttribute("search_camera", search_camera);
        return "Product/Camera/searchCamera";
    }
}
