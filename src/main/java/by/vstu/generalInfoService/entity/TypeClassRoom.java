package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "type_classroom")
@AttributeOverride(name = "id", column = @Column(name = "type_classroom_id"))
public class TypeClassRoom extends AbstractEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "short_name")
	private String shortName;

	@OneToMany(
		cascade = {CascadeType.PERSIST, CascadeType.MERGE},
		mappedBy = "typeClassRoom", fetch = FetchType.LAZY
	)
	private List<ClassRoom> classRooms = new ArrayList<>();

}
