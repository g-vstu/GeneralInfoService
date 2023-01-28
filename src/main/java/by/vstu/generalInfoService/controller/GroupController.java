package by.vstu.generalInfoService.controller;

import by.vstu.generalInfoService.dto.GroupDTO;
import by.vstu.generalInfoService.entity.Faculty;
import by.vstu.generalInfoService.entity.Group;
import by.vstu.generalInfoService.service.GroupService;
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
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Operation(summary = "Get all Group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Group",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Group.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Group",
                    content = @Content)
    })
    @GetMapping
    public List<GroupDTO> getAll() {
        return groupService.findAll();
    }

    @Operation(summary = "Get Group by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Group",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Group.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Group",
                    content = @Content)
    })
    @GetMapping("{id}")
    public GroupDTO getBuId(
            @Parameter(description = "id of Group to be searched")
            @PathVariable("id") Long id) {
        return groupService.findOne(id);
    }

    @Operation(summary = "Get Group by query params")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the Group",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Group.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Cant found Group",
                    content = @Content)
    })
    @GetMapping("search")
    public List<GroupDTO> search(
            @Parameter(name = "Query params for search",
                    description = "This query supports logical operations and some sampling functions. " +
                            "\nSupport logical AND(;) and OR(,) between functions." +
                            "\nFor applying sampling function LIKE in query search use * instead of% as when using LIKE in sql" +
                            "\n\nFor more information https://www.baeldung.com/rest-api-search-language-rsql-fiql",
                    example = "q=name==О*")
            @RequestParam("q") String query) {
        return groupService.search(query);
    }
}
