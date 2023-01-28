package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.SpecialtyDTO;
import by.vstu.generalInfoService.entity.Specialty;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface SpecialityService extends CRUDService<SpecialtyDTO>, RSQLSearch<Specialty> {

    List<SpecialtyDTO> search (String query);
}
