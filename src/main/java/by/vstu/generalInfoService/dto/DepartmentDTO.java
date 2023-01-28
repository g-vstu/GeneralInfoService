package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.entity.Faculty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentDTO extends AbstractDTO {

    private String name;

    private String shortName;

    private String departmentAuditoriumNumber;
}
