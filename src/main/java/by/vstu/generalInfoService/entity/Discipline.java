package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "discipline")
@AttributeOverride(name = "id", column = @Column(name = "discipline_id"))
public class Discipline extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
