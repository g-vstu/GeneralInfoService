package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.entity.Specialty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GroupDTO extends AbstractDTO {

    private String name;

    private Date yearStart;

    private Date yearEnd;

    @JsonIgnoreProperties(value =  {"id", "status", "created", "updated", "shortName", "codeSpeciality", "trainingPeriod",
            "qualification", "discription", "faculty", "groups", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Specialty specialty;

    private Integer сourse;
}