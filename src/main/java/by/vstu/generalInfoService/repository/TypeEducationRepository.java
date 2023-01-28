package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.TypeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeEducationRepository extends JpaRepository<TypeEducation, Long>, JpaSpecificationExecutor<TypeEducation> {
}
