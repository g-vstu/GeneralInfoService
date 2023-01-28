package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.TypeClassDTO;
import by.vstu.generalInfoService.entity.TypeClass;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.TypeClassRepository;
import by.vstu.generalInfoService.service.TypeClassService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeClassServiceImpl
        extends CommonCRUDServiceImpl<TypeClass, TypeClassDTO, TypeClassRepository>
        implements TypeClassService {

    @Autowired
    private Mapper<TypeClass, TypeClassDTO> mapper;

    @Autowired
    private TypeClassRepository typeClassRepository;

    public TypeClassServiceImpl() {
        super(TypeClass.class, TypeClassDTO.class);
    }

    @Override
    public List<TypeClassDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(typeClassRepository.findAll(getSpecifications(query)), TypeClassDTO.class);
    }
}
