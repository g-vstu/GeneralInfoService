package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.PeriodClassDTO;
import by.vstu.generalInfoService.entity.Group;
import by.vstu.generalInfoService.entity.PeriodClass;
import by.vstu.generalInfoService.service.PeriodClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classes")
public class PeriodClassController {

    @Autowired
    private PeriodClassService periodClassService;

    @Operation(summary = "Get all PeriodClass")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the PeriodClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeriodClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found PeriodClass",
                    content = @Content)
    })
    @GetMapping
    public List<PeriodClassDTO> getAll() {
        return periodClassService.findAll();
    }

    @Operation(summary = "Get PeriodClass which is being held now")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the PeriodClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeriodClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found PeriodClass",
                    content = @Content)
    })
    @GetMapping("now")
    public PeriodClassDTO getByTime() {
        return periodClassService.getByTime();
    }

    @Operation(summary = "Get PeriodClass by time")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the PeriodClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeriodClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found PeriodClass",
                    content = @Content)
    })
    @GetMapping("by-time")
    public PeriodClassDTO getByTime(
            @Parameter(description = "Insert time in format \"hh:mm:ss\"",
            example = "8:40")
            @RequestParam("time") String time) {
        return periodClassService.getByTime(time);
    }

    @Operation(summary = "Get PeriodClass by nubmer class")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the PeriodClass",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeriodClass.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found PeriodClass",
                    content = @Content)
    })
    @GetMapping("by-number")
    public PeriodClassDTO getByNumberOfClass(
            @Parameter(description = "Insert number of class",
                    example = "1")
            @RequestParam("number") Integer number) {
        return periodClassService.getByNumberOfClass(number);
    }

}
