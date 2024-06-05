package com.example.deplom.controllers;

import com.example.deplom.models.Tripod;
import com.example.deplom.repository.TripodRepository;
import com.example.deplom.service.TripodService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tripod-page")
public class PageTripodController {
    private TripodRepository tripodRepository;
    private TripodService tripodService;
    public PageTripodController(TripodRepository tripodRepository, TripodService tripodService) {
        this.tripodRepository = tripodRepository;
        this.tripodService = tripodService;
    }

    @GetMapping()
    public String displayingTripodPage(Model model){
        Iterable<Tripod> tripod = tripodRepository.findAll();
        model.addAttribute("tripod", tripod);
        return "Product/Tripod/tripodPage";
    }

    @GetMapping("/page-tripod-id/{id}")
    public String creatingProductPageTripod(Model model, @PathVariable("id") Long id){
        Optional<Tripod> tripod_id = tripodRepository.findById(id);
        model.addAttribute("tripod_id", tripod_id);
        return "Product/Tripod/productPageTripod";
    }

    @GetMapping("/page-create-tripod")
    public String pageCreateTripod(){
        return "Product/Tripod/pageAddTripod";
    }

    @PostMapping("/page-create-tripod")
    public String pageAddTripod(@RequestParam String type,
                              @RequestParam String head,
                              @RequestParam String dimensions,
                              @RequestParam String material,
                              @RequestParam String legSection,
                              @RequestParam String headType,
                              @RequestParam double price
    ){

        Tripod tripod = new Tripod();
        tripod.setType(type);
        tripod.setHead(head);
        tripod.setDimensions(dimensions);
        tripod.setMaterial(material);
        tripod.setLegSection(legSection);
        tripod.setHeadType(headType);
        tripod.setPrice(price);

        tripodRepository.save(tripod);
        return "redirect:/tripod-page";
    }

    @GetMapping("/page-update-tripod")
    public String pageUpdateTripod(@RequestParam("id") Long id, Model model){
        Optional<Tripod> tripod_id = tripodRepository.findById(id);
        model.addAttribute("tripod_id", tripod_id);
        return "Product/Tripod/pageUpdateTripod";
    }

    @PostMapping("/page-update-tripod")
    public String pageUpdateTripod(@RequestParam("id") Long id,
                                   @RequestParam String type,
                                   @RequestParam String head,
                                   @RequestParam String dimensions,
                                   @RequestParam String material,
                                   @RequestParam String legSection,
                                   @RequestParam String headType,
                                   @RequestParam double price
    ){
        Optional<Tripod> tripodOptional = tripodRepository.findById(id);
        Tripod tripod = tripodOptional.orElseThrow(() -> new NotFoundException("Not found tripod by id" + id));

        tripod.setType(type);
        tripod.setHead(head);
        tripod.setDimensions(dimensions);
        tripod.setMaterial(material);
        tripod.setLegSection(legSection);
        tripod.setHeadType(headType);
        tripod.setPrice(price);

        tripodRepository.save(tripod);
        return "redirect:/tripod-page";
    }

    @GetMapping("/delete-tripod")
    public String deleteTripodById(@RequestParam("id") Long id){
        tripodService.deleteTripodById(id);
        return "redirect:/tripod-page";
    }
}
