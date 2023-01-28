package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.FacultyDTO;
import by.vstu.generalInfoService.entity.Faculty;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface FacultyService extends CRUDService<FacultyDTO>, RSQLSearch<Faculty> {

    List<FacultyDTO> search(String query);
}
