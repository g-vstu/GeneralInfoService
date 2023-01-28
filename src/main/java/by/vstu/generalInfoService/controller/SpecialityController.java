package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.SpecialtyDTO;
import by.vstu.generalInfoService.entity.Specialty;
import by.vstu.generalInfoService.service.SpecialityService;
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
@RequestMapping("specialities")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @Operation(summary = "Get all Specialty")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Specialty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Specialty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Specialty",
                    content = @Content)
    })
    @GetMapping
    public List<SpecialtyDTO> getAll() {
        return specialityService.findAll();
    }

    @Operation(summary = "Get Specialty by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Specialty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Specialty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Specialty",
                    content = @Content)
    })
    @GetMapping("{id}")
    public SpecialtyDTO getById(
            @Parameter(description = "id of Specialty to be searched")
            @PathVariable("id") Long id) {
        return specialityService.findOne(id);
    }

    @Operation(summary = "Get Specialty by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Specialty",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Specialty.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Specialty",
                    content = @Content)
    })
    @GetMapping("search")
    public List<SpecialtyDTO> search (
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query){
        return specialityService.search(query);
    }
}
