package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "department")
@AttributeOverride(name = "id", column = @Column(name = "department_id"))
public class Department extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "department_auditorium_number")
    private String departmentAuditoriumNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department", fetch = FetchType.LAZY)
    private List<Group> groups = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department", fetch = FetchType.LAZY)
    private List<Discipline> disciplines = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department", fetch = FetchType.LAZY)
    private List<Staff> staffList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department", fetch = FetchType.LAZY)
    private List<ClassRoom> classRooms = new ArrayList<>();
}
