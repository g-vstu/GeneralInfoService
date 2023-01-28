package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import lombok.Data;

@Data
public class FacultyDTO extends AbstractDTO {

    private String name;
    private String shortName;
    private String dean;
    private String discription;
}
