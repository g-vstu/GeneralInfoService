package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.FacultyDTO;
import by.vstu.generalInfoService.entity.Employee;
import by.vstu.generalInfoService.entity.Faculty;
import by.vstu.generalInfoService.service.FacultyService;
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
@RequestMapping("faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Operation(summary = "Get all Faculty")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Faculty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Faculty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Faculty",
                    content = @Content)
    })
    @GetMapping
    public List<FacultyDTO> getAll() {
        return facultyService.findAll();
    }

    @Operation(summary = "Get Faculty by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Faculty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Faculty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Faculty",
                    content = @Content)
    })
    @GetMapping("{id}")
    public FacultyDTO getById(
            @Parameter(description = "id of Faculty to be searched")
            @PathVariable("id") Long id) {
        return facultyService.findOne(id);
    }

    @Operation(summary = "Get Faculty by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Faculty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Faculty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Faculty",
                    content = @Content)
    })
    @GetMapping("search")
    public List<FacultyDTO> getByTypeEducation(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query) {
        return facultyService.search(query);
    }
}
