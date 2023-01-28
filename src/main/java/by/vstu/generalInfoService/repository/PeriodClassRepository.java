package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.PeriodClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;

public interface PeriodClassRepository extends JpaRepository<PeriodClass, Long> {

    @Query("SELECT pc FROM PeriodClass pc WHERE pc.timeStart <= :time AND pc.timeStop >= :time ")
    PeriodClass findByTime(LocalTime time);

    PeriodClass findByNumberClass(Integer number);
}
