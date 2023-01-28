package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.StudentDTO;
import by.vstu.generalInfoService.entity.Student;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface StudentService extends CRUDService<StudentDTO>, RSQLSearch<Student> {

    List<StudentDTO> search(String query);
}
