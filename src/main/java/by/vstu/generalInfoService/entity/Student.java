package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student")
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
public class Student extends AbstractEntity {

    @Column(name = "number_studentbook")
    private Integer numberStudentbook;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "list_identificatior")
    private Integer listIdentificatior;

    @Column(name = "sub_group_identificator")
    private Integer subGroupIdentificator;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
