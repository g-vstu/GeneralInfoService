package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.StudentDTO;
import by.vstu.generalInfoService.entity.Specialty;
import by.vstu.generalInfoService.entity.Student;
import by.vstu.generalInfoService.service.StudentService;
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
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Get all Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Student",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Student",
                    content = @Content)
    })
    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.findAll();
    }

    @Operation(summary = "Get Student by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Student",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Student",
                    content = @Content)
    })
    @GetMapping("{id}")
    public StudentDTO getById(
            @Parameter(description = "id of Student to be searched")
            @PathVariable("id") Long id) {
        return studentService.findOne(id);
    }

    @Operation(summary = "Get Student by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Student",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Student.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Student",
                    content = @Content)
    })
    @GetMapping("search")
    public List<StudentDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query) {
        return studentService.search(query);
    }
}
