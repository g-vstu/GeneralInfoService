package by.vstu.generalInfoService.entity;

import by.vstu.generalInfoService.entity.common.AbstractEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "classroom")
@AttributeOverride(name = "id", column = @Column(name = "classroom_id"))
public class ClassRoom extends AbstractEntity {

	@Column(name = "frame")
	private String frame;
	@Column(name = "location")
	private String location;
	@Column(name = "seats")
	private Integer seats;
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_classroom_id")
	private TypeClassRoom typeClassRoom;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;
}
