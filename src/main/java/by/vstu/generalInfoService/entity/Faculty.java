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
@Table(name = "faculty")
@AttributeOverride(name = "id", column = @Column(name = "faculty_id"))
public class Faculty extends AbstractEntity {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "faculty", fetch = FetchType.LAZY)
    List<Department> departments = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "faculty", fetch = FetchType.LAZY)
    List<Specialty> specialties = new ArrayList<>();
    @Column(name = "name")
    private String name;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "dean")
    private String dean;
    @Column(name = "discription")
    private String discription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_education_id")
    private TypeEducation typeEducation;
}
