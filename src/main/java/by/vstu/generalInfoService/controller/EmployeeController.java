package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.EmployeeDTO;
import by.vstu.generalInfoService.entity.Discipline;
import by.vstu.generalInfoService.entity.Employee;
import by.vstu.generalInfoService.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Employee",
                    content = @Content)
    })
    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Get Employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Employee",
                    content = @Content)
    })
    @GetMapping("{id}")
    public EmployeeDTO getBuId(
            @Parameter(description = "id of Employee to be searched")
            @PathVariable("id") Long id) {
        return employeeService.findOne(id);
    }

    @Operation(summary = "Get Employee by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Employee",
                    content = @Content)
    })
    @GetMapping("search")
    public List<EmployeeDTO> search (
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==В*")
            @RequestParam("q") String query){
        return employeeService.search(query);
    }
}
