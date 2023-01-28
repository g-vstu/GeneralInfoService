package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.TypeClassRoomDTO;
import by.vstu.generalInfoService.entity.TypeClassRoom;
import by.vstu.generalInfoService.service.TypeClassRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type-classrooms")
public class TypeClassRoomController {


	@Autowired
	private TypeClassRoomService typeClassRoomService;

	@Operation(summary = "Get all Departments")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Found the departments",
			content = {@Content(mediaType = "application/json",
				schema = @Schema(implementation = TypeClassRoom.class))}),
		@ApiResponse(responseCode = "400",
			description = "Cant found departments",
			content = @Content)
	})
	@GetMapping
	public List<TypeClassRoomDTO> getAll() {
		return typeClassRoomService.findAll();
	}

	@Operation(summary = "Get departments by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Found the departments",
			content = {@Content(mediaType = "application/json",
				schema = @Schema(implementation = TypeClassRoom.class))}),
		@ApiResponse(responseCode = "400",
			description = "Cant found departments",
			content = @Content)
	})
	@GetMapping("{id}")
	public TypeClassRoomDTO getById(
		@Parameter(description = "id of department to be searched")
		@PathVariable("id") Long id) {
		return typeClassRoomService.findOne(id);
	}

	@Operation(summary = "Get departments by query params")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Found the departments",
			content = {@Content(mediaType = "application/json",
				schema = @Schema(implementation = TypeClassRoom.class))}),
		@ApiResponse(responseCode = "400",
			description = "Cant found departments",
			content = @Content)
	})
	@GetMapping("search")
	public List<TypeClassRoomDTO> search(
		@Parameter(name = "Query params for search",
			description = "This query supports logical operations and some sampling functions. " +
				"\nSupport logical AND(;) and OR(,) between functions." +
				"\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql"
				+
				"\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
			example = "q=faculty.name==ФИТ*;shortName==ИСАП")
		@RequestParam("q") String query) {
		return typeClassRoomService.search(query);
	}

}
