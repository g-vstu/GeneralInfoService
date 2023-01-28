package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.SpecialtyDTO;
import by.vstu.generalInfoService.entity.Specialty;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.SpecialityRepository;
import by.vstu.generalInfoService.service.SpecialityService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl
        extends CommonCRUDServiceImpl<Specialty, SpecialtyDTO, SpecialityRepository>
        implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private Mapper<Specialty, SpecialtyDTO> mapper;

    public SpecialityServiceImpl() {
        super(Specialty.class, SpecialtyDTO.class);
    }

    @Override
    public List<SpecialtyDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(specialityRepository.findAll(getSpecifications(query)), SpecialtyDTO.class);
    }
}
