package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO extends AbstractDTO {

    private Integer numberStudentbook;

    private String surname;

    private String name;

    private String patronymic;

    private LocalDate birthday;

    private String phone;

    private String address;

    private Integer listIdentificatior;

    private Integer subGroupIdentificator;

    private Boolean paid;
    
    private String groupName;
}
