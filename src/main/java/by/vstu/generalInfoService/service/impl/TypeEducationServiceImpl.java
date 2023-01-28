package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.TypeEducationDTO;
import by.vstu.generalInfoService.entity.TypeEducation;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.TypeEducationRepository;
import by.vstu.generalInfoService.service.TypeEducationService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEducationServiceImpl
        extends CommonCRUDServiceImpl<TypeEducation, TypeEducationDTO, TypeEducationRepository>
        implements TypeEducationService {

    @Autowired
    private TypeEducationRepository typeEducationRepository;

    @Autowired
    private Mapper<TypeEducation, TypeEducationDTO> mapper;

    public TypeEducationServiceImpl() {
        super(TypeEducation.class, TypeEducationDTO.class);
    }

    @Override
    public List<TypeEducationDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(typeEducationRepository.findAll(getSpecifications(query)), TypeEducationDTO.class);
    }
}
