package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.TypeClassDTO;
import by.vstu.generalInfoService.entity.TypeClass;
import by.vstu.generalInfoService.service.TypeClassService;
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
@RequestMapping("types-of-classes")
public class TypeClassController {

    @Autowired
    private TypeClassService typeClassService;

    @Operation(summary = "Get all TypeClass")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the TypeClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TypeClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found TypeClass",
                    content = @Content)
    })
    @GetMapping
    public List<TypeClassDTO> getAll() {
        return typeClassService.findAll();
    }

    @Operation(summary = "Get TypeClass by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the TypeClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TypeClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found TypeClass",
                    content = @Content)
    })
    @GetMapping("{id}")
    public TypeClassDTO getById(
            @Parameter(description = "id of TypeClass to be searched")
            @PathVariable("id") Long id) {
        return typeClassService.findOne(id);
    }
    @GetMapping("search")
    public List<TypeClassDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query) {
        return typeClassService.search(query);
    }
}
