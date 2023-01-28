package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.ClassRoomDTO;
import by.vstu.generalInfoService.entity.ClassRoom;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.ClassRoomRepository;
import by.vstu.generalInfoService.service.ClassRoomService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl
	extends CommonCRUDServiceImpl<ClassRoom, ClassRoomDTO, ClassRoomRepository>
	implements ClassRoomService {


	@Autowired
	private ClassRoomRepository classRoomRepository;
	@Autowired
	private Mapper<ClassRoom, ClassRoomDTO> mapper;

	public ClassRoomServiceImpl() {
		super(ClassRoom.class, ClassRoomDTO.class);
	}

	@Override
	public List<ClassRoomDTO> search(String query) {
		if (query.isEmpty()) {
			return findAll();
		}
		return mapper
			.toDTOs(classRoomRepository.findAll(getSpecifications(query)), ClassRoomDTO.class);
	}
}
