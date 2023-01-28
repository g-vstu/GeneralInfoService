package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecialityRepository extends JpaRepository<Specialty, Long>, JpaSpecificationExecutor<Specialty> {
}
