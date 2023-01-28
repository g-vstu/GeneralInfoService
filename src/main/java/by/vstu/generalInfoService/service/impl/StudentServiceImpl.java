package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.StudentDTO;
import by.vstu.generalInfoService.entity.Student;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.StudentRepository;
import by.vstu.generalInfoService.service.StudentService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl
        extends CommonCRUDServiceImpl<Student, StudentDTO, StudentRepository>
        implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Mapper<Student, StudentDTO> mapper;

    public StudentServiceImpl() {
        super(Student.class, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(studentRepository.findAll(getSpecifications(query)), StudentDTO.class);
    }
}
