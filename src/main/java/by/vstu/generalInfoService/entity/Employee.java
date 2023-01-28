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
@Table(name = "employee")
@AttributeOverride(name = "id", column = @Column(name = "employee_id"))
public class Employee extends AbstractEntity {

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "degree")
    private String degree;

    @Column(name = "position")
    private String position;

    @Column(name = "photo")
    private String photo;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "employee")
    private List<Staff> staffList = new ArrayList<>();
}
