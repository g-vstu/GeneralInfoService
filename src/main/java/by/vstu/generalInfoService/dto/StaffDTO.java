package by.vstu.generalInfoService.dto;

import by.vstu.generalInfoService.dto.common.AbstractDTO;
import by.vstu.generalInfoService.entity.Department;
import by.vstu.generalInfoService.entity.Employee;
import lombok.Data;

@Data
public class StaffDTO extends AbstractDTO {

    private Department department;

    private Employee employee;
}
