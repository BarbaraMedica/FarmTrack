package hr.example.farmtrack.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicinski_zapisi")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datumPregleda;

    private String terapija;

    private Double kolicinaMlijeka;

    @Column(length = 1000)
    private String biljeske;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(LocalDate datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public String getTerapija() {
        return terapija;
    }

    public void setTerapija(String terapija) {
        this.terapija = terapija;
    }

    public Double getKolicinaMlijeka() {
        return kolicinaMlijeka;
    }

    public void setKolicinaMlijeka(Double kolicinaMlijeka) {
        this.kolicinaMlijeka = kolicinaMlijeka;
    }

    public String getBiljeske() {
        return biljeske;
    }

    public void setBiljeske(String biljeske) {
        this.biljeske = biljeske;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}