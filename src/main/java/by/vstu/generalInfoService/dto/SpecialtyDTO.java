package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpecialtyDTO extends AbstractDTO {

    private String name;

    private String shortName;

    private String codeSpeciality;

    private Float trainingPeriod;

    private String qualification;

    private String discription;
}
