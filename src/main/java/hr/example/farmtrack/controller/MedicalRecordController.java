package hr.example.farmtrack.controller;

import hr.example.farmtrack.entity.Animal;
import hr.example.farmtrack.entity.MedicalRecord;
import hr.example.farmtrack.repository.AnimalRepository;
import hr.example.farmtrack.repository.MedicalRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pregledi")
public class MedicalRecordController {

    private final MedicalRecordRepository medicalRecordRepository;
    private final AnimalRepository animalRepository;

    public MedicalRecordController(
            MedicalRecordRepository medicalRecordRepository,
            AnimalRepository animalRepository) {

        this.medicalRecordRepository = medicalRecordRepository;
        this.animalRepository = animalRepository;
    }

    @GetMapping("/novi/{animalId}")
    public String noviPregled(@PathVariable Long animalId,
                              Model model) {

        Animal animal = animalRepository.findById(animalId)
                .orElseThrow();

        MedicalRecord pregled = new MedicalRecord();
        pregled.setAnimal(animal);

        model.addAttribute("pregled", pregled);

        return "pregled-forma";
    }

    @PostMapping("/spremi")
    public String spremi(@ModelAttribute MedicalRecord pregled) {

        medicalRecordRepository.save(pregled);

        return "redirect:/zivotinje/" +
                pregled.getAnimal().getId();
    }
}