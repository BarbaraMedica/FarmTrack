package hr.example.farmtrack.repository;

import hr.example.farmtrack.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Long> {
}