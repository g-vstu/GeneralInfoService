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
@Table(name = "type_education")
@AttributeOverride(name = "id", column = @Column(name = "type_education_id"))
public class TypeEducation extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "typeEducation", fetch = FetchType.LAZY)
    private List<Faculty> faculties = new ArrayList<>();
}
