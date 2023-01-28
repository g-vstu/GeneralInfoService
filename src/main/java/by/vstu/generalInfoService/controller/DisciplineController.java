package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.DisciplineDTO;
import by.vstu.generalInfoService.entity.Department;
import by.vstu.generalInfoService.entity.Discipline;
import by.vstu.generalInfoService.service.DisciplineService;
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
@RequestMapping("disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Operation(summary = "Get all Discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Discipline",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Discipline.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Discipline",
                    content = @Content)
    })
    @GetMapping
    public List<DisciplineDTO> getAll() {
        return disciplineService.findAll();
    }

    @Operation(summary = "Get discipline by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the discipline",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Discipline.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found discipline",
                    content = @Content)
    })
    @GetMapping("{id}")
    public DisciplineDTO getById(
            @Parameter(description = "id of discipline to be searched")
            @PathVariable("id") Long id) {
        return disciplineService.findOne(id);
    }

    @Operation(summary = "Get departments by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the departments",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Discipline.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found departments",
                    content = @Content)
    })
    @GetMapping("search")
    public List<DisciplineDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=department.shortName==ИСАП")
            @RequestParam("q") String query) {
        return disciplineService.search(query);
    }

}
