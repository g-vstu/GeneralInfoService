package by.vstu.generalInfoService.service.impl;

import by.vstu.generalInfoService.dto.TypeClassRoomDTO;
import by.vstu.generalInfoService.entity.TypeClassRoom;
import by.vstu.generalInfoService.mapper.Mapper;
import by.vstu.generalInfoService.repository.TypeClassRoomRepository;
import by.vstu.generalInfoService.service.TypeClassRoomService;
import by.vstu.generalInfoService.service.common.impl.CommonCRUDServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeClassRoomServiceImpl
	extends CommonCRUDServiceImpl<TypeClassRoom, TypeClassRoomDTO, TypeClassRoomRepository>
	implements TypeClassRoomService {


	@Autowired
	private TypeClassRoomRepository typeClassRoomRepository;
	@Autowired
	private Mapper<TypeClassRoom, TypeClassRoomDTO> mapper;

	public TypeClassRoomServiceImpl() {
		super(TypeClassRoom.class, TypeClassRoomDTO.class);
	}

	@Override
	public List<TypeClassRoomDTO> search(String query) {
		if (query.isEmpty()) {
			return findAll();
		}
		return mapper
			.toDTOs(typeClassRoomRepository.findAll(getSpecifications(query)),
				TypeClassRoomDTO.class);
	}

}
