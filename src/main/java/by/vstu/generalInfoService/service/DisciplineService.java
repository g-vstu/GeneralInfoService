package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.DisciplineDTO;
import by.vstu.generalInfoService.entity.Discipline;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface DisciplineService extends CRUDService<DisciplineDTO>, RSQLSearch<Discipline> {

    List<DisciplineDTO> search (String query);
}
