package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.PeriodClassDTO;
import by.vstu.generalInfoService.service.common.CRUDService;

public interface PeriodClassService extends CRUDService<PeriodClassDTO> {

    PeriodClassDTO getByTime();

    PeriodClassDTO getByTime(String time);

    PeriodClassDTO getByNumberOfClass(Integer number);
}
