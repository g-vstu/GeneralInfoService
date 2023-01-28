package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.TypeClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeClassRoomRepository extends
	JpaRepository<TypeClassRoom, Long>,
	JpaSpecificationExecutor<TypeClassRoom> {

}
