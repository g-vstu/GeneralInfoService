package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.StaffDTO;
import by.vstu.generalInfoService.entity.Staff;
import by.vstu.generalInfoService.repository.StaffRepository;
import by.vstu.generalInfoService.service.StaffService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl
        extends CommonCRUDServiceImpl<Staff, StaffDTO, StaffRepository>
        implements StaffService {

    public StaffServiceImpl() {
        super(Staff.class, StaffDTO.class);
    }
}
