package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDTO extends AbstractDTO {

    private String surname;

    private String name;

    private String patronymic;

    private String degree;

    private String position;

    private String photo;
}
