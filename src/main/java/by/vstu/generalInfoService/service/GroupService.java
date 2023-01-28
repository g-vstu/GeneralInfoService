package by.vstu.generalInfoService.service;

import by.vstu.generalInfoService.dto.GroupDTO;
import by.vstu.generalInfoService.entity.Group;
import by.vstu.generalInfoService.service.common.CRUDService;
import by.vstu.generalInfoService.service.common.RSQLSearch;

import java.util.List;

public interface GroupService extends CRUDService<GroupDTO>, RSQLSearch<Group> {

    List<GroupDTO> search(String query);

}
