package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.PeriodClassDTO;
import by.vstu.generalInfoService.entity.PeriodClass;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.PeriodClassRepository;
import by.vstu.generalInfoService.service.PeriodClassService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class PeriodClassServiceImpl
        extends CommonCRUDServiceImpl<PeriodClass, PeriodClassDTO, PeriodClassRepository>
        implements PeriodClassService {

    @Autowired
    private PeriodClassRepository periodClassRepository;

    @Autowired
    Mapper<PeriodClass, PeriodClassDTO> mapper;

    public PeriodClassServiceImpl() {
        super(PeriodClass.class, PeriodClassDTO.class);
    }

    @Override
    public PeriodClassDTO getByTime() {
        PeriodClass result = periodClassRepository.findByTime(LocalTime.now());
        if (result == null) {
            throw new IllegalArgumentException("No classes now");
        }
        return mapper.toDTO(result, PeriodClassDTO.class);
    }

    @Override
    public PeriodClassDTO getByTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm[:ss]");
        LocalTime localTime = LocalTime.now();
        try {
            localTime = LocalTime.parse(time, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Wring format time. Mast be \"hh:mm:ss\"");
        }
        return mapper.toDTO(periodClassRepository.findByTime(localTime), PeriodClassDTO.class);
    }

    @Override
    public PeriodClassDTO getByNumberOfClass(Integer number) {
        if (number > 7 || number < 1) {
            throw new IllegalArgumentException("Not valid number of class");
        }
        return mapper.toDTO(periodClassRepository.findByNumberClass(number), PeriodClassDTO.class);
    }
}
