package hr.example.farmtrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "zivotinje")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Broj markice je obavezan")
    private String brojMarkice;

    @NotBlank(message = "Ime životinje je obavezno")
    private String ime;

    private String pasmina;

    private LocalDate datumRodenja;

    private String spol;

    private String status;

    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<MedicalRecord> medicinskiZapisi;
    // GET / SET

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojMarkice() {
        return brojMarkice;
    }

    public void setBrojMarkice(String brojMarkice) {
        this.brojMarkice = brojMarkice;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPasmina() {
        return pasmina;
    }

    public void setPasmina(String pasmina) {
        this.pasmina = pasmina;
    }

    public LocalDate getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(LocalDate datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MedicalRecord> getMedicinskiZapisi() {
        return medicinskiZapisi;
    }

    public void setMedicinskiZapisi(List<MedicalRecord> medicinskiZapisi) {
        this.medicinskiZapisi = medicinskiZapisi;
    }

}