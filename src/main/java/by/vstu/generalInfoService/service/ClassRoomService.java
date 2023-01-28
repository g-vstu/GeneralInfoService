package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.ClassRoomDTO;
import by.vstu.generalInfoService.entity.ClassRoom;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;
import java.util.List;

public interface ClassRoomService extends CRUDService<ClassRoomDTO>, RSQLSearch<ClassRoom> {

	List<ClassRoomDTO> search(String query);

}
