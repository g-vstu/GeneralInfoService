package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.TypeEducationDTO;
import by.vstu.generalInfoService.entity.TypeEducation;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface TypeEducationService extends CRUDService<TypeEducationDTO>, RSQLSearch<TypeEducation> {

    List<TypeEducationDTO> search(String query);
}
