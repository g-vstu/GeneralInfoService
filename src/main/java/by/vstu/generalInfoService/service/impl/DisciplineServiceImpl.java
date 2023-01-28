package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.DisciplineDTO;
import by.vstu.generalInfoService.entity.Discipline;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.DisciplineRepository;
import by.vstu.generalInfoService.service.DisciplineService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl
        extends CommonCRUDServiceImpl<Discipline, DisciplineDTO, DisciplineRepository>
        implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private Mapper<Discipline, DisciplineDTO> mapper;

    public DisciplineServiceImpl() {
        super(Discipline.class, DisciplineDTO.class);
    }

    @Override
    public List<DisciplineDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(disciplineRepository.findAll(getSpecifications(query)), DisciplineDTO.class);
    }
}
