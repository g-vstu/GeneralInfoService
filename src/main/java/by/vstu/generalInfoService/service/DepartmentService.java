package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.DepartmentDTO;
import by.vstu.generalInfoService.entity.Department;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface DepartmentService extends CRUDService<DepartmentDTO>, RSQLSearch<Department> {

    List<DepartmentDTO> search(String query);
}
