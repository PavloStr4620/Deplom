package com.example.deplom.controllers.product;
import com.example.deplom.models.Lens;
import com.example.deplom.repository.LensRepository;
import com.example.deplom.service.LensService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lens-page")
public class PageLensController {
    private final LensRepository lensRepository;
    private final LensService lensService;

    public PageLensController(LensRepository lensRepository, LensService lensService) {
        this.lensRepository = lensRepository;
        this.lensService = lensService;
    }

    @GetMapping
    public String displayingLensPage(Model model,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Lens> lens = lensRepository.findAll(pageable);
        model.addAttribute("lens", lens);
        return "Product/Lens/lensPage";
    }

    @GetMapping("/page-lens-id/{id}")
    public String creatingProductPageLens(Model model, @PathVariable("id") Long id) {
        Optional<Lens> lens_id = lensRepository.findById(id);
        model.addAttribute("lens_id", lens_id);
        return "Product/Lens/productPageLens";
    }

    @GetMapping("/page-create-lens")
    public String pageCreateLens() {
        return "Product/Lens/pageAddLens";
    }

    @PostMapping("/page-create-lens")
    public String pageAddLens(@RequestParam String bayonet,
                              @RequestParam String focalLength,
                              @RequestParam String lensType,
                              @RequestParam String focus,
                              @RequestParam String manufacturers,
                              @RequestParam String direction,
                              @RequestParam String matrixFormat,
                              @RequestParam String weight,
                              @RequestParam double price
    ) {

        Lens lens = new Lens();
        lens.setBayonet(bayonet);
        lens.setFocalLength(focalLength);
        lens.setLensType(lensType);
        lens.setFocus(focus);
        lens.setManufacturers(manufacturers);
        lens.setDirection(direction);
        lens.setMatrixFormat(matrixFormat);
        lens.setWeight(weight);
        lens.setPrice(price);

        lensRepository.save(lens);
        return "redirect:/lens-page";
    }

    @GetMapping("/page-update-lens")
    public String pageUpdateLens(@RequestParam("id") Long id, Model model) {
        Optional<Lens> lens_id = lensRepository.findById(id);
        model.addAttribute("lens_id", lens_id);
        return "Product/Lens/pageUpdateLens";
    }

    @PostMapping("/page-update-lens")
    public String pageUpdateLens(@RequestParam("id") Long id,
                                 @RequestParam String bayonet,
                                 @RequestParam String focalLength,
                                 @RequestParam String lensType,
                                 @RequestParam String focus,
                                 @RequestParam String manufacturers,
                                 @RequestParam String direction,
                                 @RequestParam String matrixFormat,
                                 @RequestParam String weight,
                                 @RequestParam double price
    ) {
        Optional<Lens> lensOptional = lensRepository.findById(id);
        Lens lens = lensOptional.orElseThrow(() -> new NotFoundException("Not found lens by id" + id));

        lens.setBayonet(bayonet);
        lens.setFocalLength(focalLength);
        lens.setLensType(lensType);
        lens.setFocus(focus);
        lens.setManufacturers(manufacturers);
        lens.setDirection(direction);
        lens.setMatrixFormat(matrixFormat);
        lens.setWeight(weight);
        lens.setPrice(price);

        lensRepository.save(lens);
        return "redirect:/lens-page";
    }

    @GetMapping("/delete-lens")
    public String deleteLensById(@RequestParam("id") Long id) {
        lensService.deleteLensById(id);
        return "redirect:/lens-page";
    }

    @GetMapping("/search-lens")
    public String searchLens(@RequestParam("bayonet") String bayonet, Model model) {
        List<Lens> search_lens = lensService.findLensByBayonet(bayonet);
        model.addAttribute("search_lens", search_lens);
        return "Product/Lens/searchLens";
    }

}
