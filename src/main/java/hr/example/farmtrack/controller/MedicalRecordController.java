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
    

    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository,
                                   AnimalRepository animalRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.animalRepository = animalRepository;
    }
    @GetMapping
    public String sviPregledi(Model model) {

        model.addAttribute(
                "pregledi",
                medicalRecordRepository.findAll());

        return "pregledi";
    }

    // FORM - NOVI PREGLED
    @GetMapping("/novi/{animalId}")
    public String novi(@PathVariable Long animalId, Model model) {

        Animal animal = animalRepository.findById(animalId)
                .orElseThrow();

        MedicalRecord m = new MedicalRecord();
        m.setAnimal(animal);

        model.addAttribute("pregled", m);

        return "pregled-forma";
    }

    @PostMapping("/spremi")
    public String spremi(@ModelAttribute MedicalRecord pregled) {

        // Ako animal nema ID ili je NULL, baca grešku
        if (pregled.getAnimal() == null || pregled.getAnimal().getId() == null) {
            throw new IllegalArgumentException("Životinja nije postavljena!");
        }

        // Učitaj cijeli animal objekat iz baze
        Animal animal = animalRepository.findById(pregled.getAnimal().getId())
                .orElseThrow(() -> new IllegalArgumentException("Životinja nije pronađena!"));

        // Postavi kompletan animal objekat
        pregled.setAnimal(animal);

        // Sada spremi pregled sa punom životnjom
        medicalRecordRepository.save(pregled);

        return "redirect:/zivotinje/" + animal.getId();
    }

    @GetMapping("/obrisi/{id}")
    public String obrisi(@PathVariable Long id) {

        MedicalRecord m = medicalRecordRepository.findById(id)
                .orElseThrow();

        Long animalId = m.getAnimal().getId();

        medicalRecordRepository.deleteById(id);

        return "redirect:/zivotinje/" + animalId;
    }

    @GetMapping("/uredi/{id}")
    public String uredi(@PathVariable Long id, Model model) {

        MedicalRecord m = medicalRecordRepository.findById(id)
                .orElseThrow();

        model.addAttribute("pregled", m);

        return "pregled-forma";
    }
}