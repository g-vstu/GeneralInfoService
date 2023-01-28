package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.GroupDTO;
import by.vstu.generalInfoService.entity.Group;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.GroupRepository;
import by.vstu.generalInfoService.service.GroupService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl
        extends CommonCRUDServiceImpl<Group, GroupDTO, GroupRepository>
        implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private Mapper<Group, GroupDTO> mapper;

    public GroupServiceImpl() {
        super(Group.class, GroupDTO.class);
    }

    @Override
    public List<GroupDTO> search(String query) {
        if (query.isEmpty()){
            return findAll();
        }
        return mapper.toDTOs(groupRepository.findAll(getSpecifications(query)), GroupDTO.class);
    }
}
