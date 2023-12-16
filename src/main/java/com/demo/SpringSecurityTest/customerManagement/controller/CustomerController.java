package com.demo.SpringSecurityTest.customerManagement.controller;

import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import com.demo.SpringSecurityTest.customerManagement.service.CustomerService;
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
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerService customerService;

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Customer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/")
    public GenericResponse<Customer>addCustomer(@RequestBody Customer customer)
    {
        try{
            return new GenericResponse<>(200,"sucess",customerService.saveCustomer(customer));
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(Customer)customer );
        }

    }

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Customer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/")
    public GenericResponse<List<Customer>>getallCustomer()
    {
        try{
            return new GenericResponse<>(200,"sucess",customerService.getAllCustomers());
        }catch(Exception e){
            return new GenericResponse<>(406,"error",(List<Customer>)null );
        }

    }

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Customer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public GenericResponse<Customer>deleteCustomer(@PathVariable Long id)
    {
        try{
            return new GenericResponse<Customer>(200,"sucess",customerService.deleteCustomer(id));
        }catch(Exception e){
            return new GenericResponse<Customer>(406,"error",(Customer)null );
        }

    }

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Customer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/")
    public GenericResponse<Customer>updateCustomer(@RequestBody Customer customer)
    {
        try{
            return new GenericResponse<Customer>(200,"sucess",customerService.updateCustomer(customer));
        }catch(Exception e){
            return new GenericResponse<Customer>(406,"error",(Customer)null );
        }

    }

}
