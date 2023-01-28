package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "specialty")
@AttributeOverride(name = "id", column = @Column(name = "specialty_id"))
public class Specialty extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "code_speciality")
    private String codeSpeciality;

    @Column(name = "training_period")
    private Float trainingPeriod;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "discription")
    private String discription;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specialty")
    private List<Group> groups = new ArrayList<>();
}
