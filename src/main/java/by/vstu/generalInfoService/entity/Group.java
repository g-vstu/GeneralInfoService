package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "students_group")
@AttributeOverride(name = "id", column = @Column(name = "group_id"))
public class Group extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "year_start")
    private Date yearStart;

    @Column(name = "year_end")
    private Date yearEnd;

    @Column(name = "course")
    private Integer сourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}
