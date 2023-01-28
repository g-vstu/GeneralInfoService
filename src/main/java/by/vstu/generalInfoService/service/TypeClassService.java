package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.TypeClassDTO;
import by.vstu.generalInfoService.entity.TypeClass;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface TypeClassService extends CRUDService<TypeClassDTO>, RSQLSearch<TypeClass> {

    List<TypeClassDTO> search(String query);
}
