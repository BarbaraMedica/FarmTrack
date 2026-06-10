package controller;

import entity.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import repository.AnimalRepository;

@Controller
@RequestMapping("/zivotinje")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public String listaZivotinja(@RequestParam(required = false) String search, Model model) {

        if (search != null && !search.isEmpty()) {
            model.addAttribute("zivotinje",
                    animalRepository.findByImeContainingIgnoreCase(search));
        } else {
            model.addAttribute("zivotinje",
                    animalRepository.findAll());
        }

        return "zivotinje";
    }

    @GetMapping("/{id}")
    public String detalji(@PathVariable Long id, Model model) {
        model.addAttribute("zivotinja",
                animalRepository.findById(id).orElseThrow());
        return "zivotinja-detalji";
    }

    @GetMapping("/nova")
    public String novaForma(Model model) {
        model.addAttribute("zivotinja", new Animal());
        return "zivotinja-forma";
    }

    @PostMapping("/spremi")
    public String spremi(@Valid @ModelAttribute("zivotinja") Animal animal,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "zivotinja-forma";
        }

        animalRepository.save(animal);
        return "redirect:/zivotinje";
    }

    @GetMapping("/uredi/{id}")
    public String uredi(@PathVariable Long id, Model model) {
        model.addAttribute("zivotinja",
                animalRepository.findById(id).orElseThrow());
        return "zivotinja-forma";
    }

    @GetMapping("/obrisi/{id}")
    public String obrisi(@PathVariable Long id) {
        animalRepository.deleteById(id);
        return "redirect:/zivotinje";
    }
}
