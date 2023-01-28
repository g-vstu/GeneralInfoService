package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.dto.DepartmentDTO;
import lombok.Data;

@Data
public class DisciplineDTO extends AbstractDTO {

    private String name;

    private String shortName;
    
    private DepartmentDTO department;
}
