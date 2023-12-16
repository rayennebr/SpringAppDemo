package com.demo.SpringSecurityTest.billManagement.controller;

import com.demo.SpringSecurityTest.billManagement.entities.Bill;
import com.demo.SpringSecurityTest.billManagement.services.BillService;
import com.demo.SpringSecurityTest.genericResponse.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
@RequiredArgsConstructor
public class BillController {
    
    private final BillService billService;


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Bill.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/")
    public GenericResponse<Bill> addBill(@RequestBody Bill bill)
    {
        try{
            return new GenericResponse<>(200,"sucess",billService.saveBill(bill));
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(Bill)bill );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Bill.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/")
    public GenericResponse<List<Bill>>getallBill()
    {
        try{
            return new GenericResponse<>(200,"sucess",billService.getAllBills());
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(List<Bill>)null );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Bill.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public GenericResponse<Bill>deleteBill(@PathVariable Long id)
    {
        try{
            return new GenericResponse<Bill>(200,"sucess",billService.deleteBill(id));
        }catch(Exception e){
            return new GenericResponse<Bill>(406,"error",(Bill)null );
        }

    }


    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Bill.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/")
    public GenericResponse<Bill>updateBill(@RequestBody Bill bill)
    {
        try{
            return new GenericResponse<Bill>(200,"sucess",billService.updateBill(bill));
        }catch(Exception e){
            return new GenericResponse<Bill>(406,"error",(Bill)null );
        }

    }
}
