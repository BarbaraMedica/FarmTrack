package hr.example.farmtrack.controller;

import hr.example.farmtrack.repository.AnimalRepository;
import hr.example.farmtrack.repository.MedicalRecordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final AnimalRepository animalRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public HomeController(AnimalRepository animalRepository,
                          MedicalRecordRepository medicalRecordRepository) {
        this.animalRepository = animalRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("brojZivotinja",
                animalRepository.count());

        model.addAttribute("brojPregleda",
                medicalRecordRepository.count());

        return "home";
    }
}