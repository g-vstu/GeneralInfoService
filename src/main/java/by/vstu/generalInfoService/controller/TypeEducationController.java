package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.TypeEducationDTO;
import by.vstu.generalInfoService.entity.Student;
import by.vstu.generalInfoService.entity.TypeClass;
import by.vstu.generalInfoService.entity.TypeEducation;
import by.vstu.generalInfoService.service.TypeEducationService;
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
@RequestMapping("types-education")
public class TypeEducationController {

    @Autowired
    private TypeEducationService typeEducationService;

    @Operation(summary = "Get all TypeEducation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the TypeEducation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TypeEducation.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found TypeEducation",
                    content = @Content)
    })
    @GetMapping
    public List<TypeEducationDTO> getAll() {
        return typeEducationService.findAll();
    }

    @Operation(summary = "Get TypeEducation by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the TypeEducation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TypeEducation.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found TypeEducation",
                    content = @Content)
    })
    @GetMapping("{id}")
    public TypeEducationDTO getById(
            @Parameter(description = "id of TypeEducation to be searched")
            @PathVariable("id") Long id) {
        return typeEducationService.findOne(id);
    }

    @Operation(summary = "Get TypeEducation by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the TypeEducation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TypeEducation.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found TypeEducation",
                    content = @Content)
    })
    @GetMapping("search")
    public List<TypeEducationDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query) {
        return typeEducationService.search(query);
    }
}
