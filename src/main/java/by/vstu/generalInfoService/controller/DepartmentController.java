package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.DepartmentDTO;
import by.vstu.generalInfoService.entity.Department;
import by.vstu.generalInfoService.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "Get all Departments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the departments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Department.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found departments",
                    content = @Content)
    })
    @GetMapping
    public List<DepartmentDTO> getAll() {
        return departmentService.findAll();
    }

    @Operation(summary = "Get departments by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the departments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Department.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found departments",
                    content = @Content)
    })
    @GetMapping("{id}")
    public DepartmentDTO getById(
            @Parameter(description = "id of department to be searched")
            @PathVariable("id") Long id) {
        return departmentService.findOne(id);
    }

    @Operation(summary = "Get departments by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the departments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Department.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found departments",
                    content = @Content)
    })
    @GetMapping("search")
    public List<DepartmentDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=faculty.name==ФИТ*;shortName==ИСАП")
            @RequestParam("q") String query) {
        return departmentService.search(query);
    }
}
