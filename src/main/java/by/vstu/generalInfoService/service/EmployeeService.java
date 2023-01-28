package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.EmployeeDTO;
import by.vstu.generalInfoService.entity.Employee;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface EmployeeService extends CRUDService<EmployeeDTO>, RSQLSearch<Employee> {

    List<EmployeeDTO> search (String query);
}
