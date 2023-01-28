package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import lombok.Data;

@Data
public class ClassRoomDTO extends AbstractDTO {

	private String frame;
	private String location;
	private Integer seats;
	private String description;

	private TypeClassRoomDTO typeClassRoom;
}
