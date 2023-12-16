package com.demo.SpringSecurityTest.promessManagement.vontroller;

import com.demo.SpringSecurityTest.genericResponse.GenericResponse;
import com.demo.SpringSecurityTest.promessManagement.entity.Promess;
import com.demo.SpringSecurityTest.promessManagement.services.PromessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promess")
@RequiredArgsConstructor
public class PromessController {

    private final PromessService promessService;

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Promess.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/")
    public GenericResponse<Promess> addPromess(@RequestBody Promess Promess)
    {
        try{
            return new GenericResponse<>(200,"sucess",promessService.addPromess(Promess));
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(Promess)Promess );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Promess.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/")
    public GenericResponse<List<Promess>>getallPromess()
    {
        try{
            return new GenericResponse<>(200,"sucess",promessService.getAllPrmoess());
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(List<Promess>)null );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Promess.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public GenericResponse<Promess>deletePromess(@PathVariable Long id)
    {
        try{
            return new GenericResponse<Promess>(200,"sucess",promessService.deletePromess(id));
        }catch(Exception e){
            return new GenericResponse<Promess>(406,"error",(Promess)null );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Promess.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/")
    public GenericResponse<Promess>updatePromess(@RequestBody Promess promess)
    {
        try{
            return new GenericResponse<Promess>(200,"sucess",promessService.updatePromess(promess));
        }catch(Exception e){
            return new GenericResponse<Promess>(406,"error",(Promess)null );
        }

    }
}
