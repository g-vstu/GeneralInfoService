package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.FacultyDTO;
import by.vstu.generalInfoService.entity.Faculty;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.FacultyRepository;
import by.vstu.generalInfoService.service.FacultyService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl
        extends CommonCRUDServiceImpl<Faculty, FacultyDTO, FacultyRepository>
        implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private Mapper<Faculty, FacultyDTO> mapper;

    public FacultyServiceImpl() {
        super(Faculty.class, FacultyDTO.class);
    }

    @Override
    public List<FacultyDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        List<Faculty> results = facultyRepository.findAll(getSpecifications(query));
        return mapper.toDTOs(results, FacultyDTO.class);
    }
}
