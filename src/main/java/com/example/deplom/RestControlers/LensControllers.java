package com.example.deplom.RestControlers;

import com.example.deplom.DTOS.LensDTO;
import com.example.deplom.models.Lens;
import com.example.deplom.service.LensService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/lens")
@RequiredArgsConstructor
public class LensControllers {
    private LensService lensService;

    @Autowired
    public LensControllers(LensService lensService) {
        this.lensService = lensService;
    }

    @PostMapping("/create-lens")
    public ResponseEntity<Lens> createLens(@RequestBody LensDTO lensDTO){
        lensService.createLens(lensDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/find-lens-by-id/{id}")
    LensDTO findLensById(@PathVariable("id") Long id) {
        return lensService.findLensById(id);
    }

    @DeleteMapping("delete-lens/{id}")
    public void deleteLensById(@PathVariable("id") Long id){
        lensService.deleteLensById(id);
    }

    @PutMapping("/update-lens/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody LensDTO lensDTO){
        lensService.updateLens(id, lensDTO);
    }

    @GetMapping("/get-all-lens")
    public List<LensDTO> getAllLens(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ){
        return lensService.getAllLens(PageRequest.of(page, size, Sort.by("bayonet")));
    }
}
