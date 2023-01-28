package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "period_class")
@AttributeOverride(name = "id", column = @Column(name = "period_class_id"))
public class PeriodClass extends AbstractEntity {

    @Column(name = "number_class")
    private Integer numberClass;

    @Column(name = "time_start")
    private LocalTime timeStart;

    @Column(name = "time_stop")
    private LocalTime timeStop;
}
