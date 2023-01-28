package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeClassRepository extends JpaRepository<TypeClass, Long>, JpaSpecificationExecutor<TypeClass> {
}
