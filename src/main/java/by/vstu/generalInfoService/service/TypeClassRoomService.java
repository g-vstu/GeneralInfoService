package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.TypeClassRoomDTO;
import by.vstu.generalInfoService.entity.TypeClassRoom;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;
import java.util.List;

public interface TypeClassRoomService extends CRUDService<TypeClassRoomDTO>,
	RSQLSearch<TypeClassRoom> {

	List<TypeClassRoomDTO> search(String query);


}
