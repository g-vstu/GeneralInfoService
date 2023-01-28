package by.vstu.generalInfoService.repository;

import by.vstu.generalInfoService.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClassRoomRepository extends
	JpaRepository<ClassRoom, Long>,
	JpaSpecificationExecutor<ClassRoom> {

}
