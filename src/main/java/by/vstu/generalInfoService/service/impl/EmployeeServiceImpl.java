package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.EmployeeDTO;
import by.vstu.generalInfoService.entity.Employee;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.EmployeeRepository;
import by.vstu.generalInfoService.service.EmployeeService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl
        extends CommonCRUDServiceImpl<Employee, EmployeeDTO, EmployeeRepository>
        implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Mapper<Employee, EmployeeDTO> mapper;

    public EmployeeServiceImpl() {
        super(Employee.class, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(employeeRepository.findAll(getSpecifications(query)), EmployeeDTO.class);
    }
}
