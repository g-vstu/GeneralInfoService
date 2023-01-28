package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.DepartmentDTO;
import by.vstu.generalInfoService.entity.Department;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.DepartmentRepository;
import by.vstu.generalInfoService.service.DepartmentService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl
        extends CommonCRUDServiceImpl<Department, DepartmentDTO, DepartmentRepository>
        implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private Mapper<Department, DepartmentDTO> mapper;

    public DepartmentServiceImpl() {
        super(Department.class, DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(departmentRepository.findAll(getSpecifications(query)), DepartmentDTO.class);
    }
}
