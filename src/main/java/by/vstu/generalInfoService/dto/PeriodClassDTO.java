package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;

@Data
public class PeriodClassDTO extends AbstractDTO {

    private Integer numberClass;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime timeStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime timeStop;
}
