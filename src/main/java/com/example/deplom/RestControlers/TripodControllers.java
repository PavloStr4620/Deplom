package com.example.deplom.RestControlers;

import com.example.deplom.DTOS.TripodDTO;
import com.example.deplom.models.Tripod;
import com.example.deplom.service.TripodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripod")
@RequiredArgsConstructor
public class TripodControllers {
    private TripodService tripodService;

    @Autowired
    public TripodControllers(TripodService tripodService) {
        this.tripodService = tripodService;
    }

    @PostMapping("/create-tripod")
    public void createTripod(@RequestBody TripodDTO tripodDTO){
        tripodService.createTripod(tripodDTO);
    }

    @GetMapping("/find-tripod-by-id/{id}")
    TripodDTO findTripodById(@PathVariable("id") Long id){
        return tripodService.findTripodById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTripodById(@PathVariable("id") Long id){
        tripodService.deleteTripodById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody TripodDTO tripodDTO){
        tripodService.updateTripod(id, tripodDTO);
    }

    @GetMapping("/get-all-tripod")
    public List<TripodDTO> getAllTripod(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ){
        return tripodService.getAllTripod(PageRequest.of(page, size, Sort.by("type")));
    }
}
