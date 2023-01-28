package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "type_class")
@AttributeOverride(name = "id", column = @Column(name = "type_class_id"))
public class TypeClass extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
