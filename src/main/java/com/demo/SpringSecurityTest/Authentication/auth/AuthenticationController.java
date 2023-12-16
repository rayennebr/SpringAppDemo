package com.demo.SpringSecurityTest.Authentication.auth;

import com.demo.SpringSecurityTest.Authentication.response.AuthenticationResponse;
import com.demo.SpringSecurityTest.genericResponse.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    public final AuthenticationService authenticationService;
    @PostMapping("/register")
    public GenericResponse<AuthenticationResponse>register(@RequestBody RegisterRequest request)
    {
        try{
            return new GenericResponse<>(200,"sucess",authenticationService.register(request));
        }catch(Exception e){
            return new GenericResponse<>(406,"error",authenticationService.register(request));
        }

    }

    @PostMapping("/signIn")
    public GenericResponse<AuthenticationResponse>signIn(@RequestBody AuthenticationRequest request)
    {
        try{
            return new GenericResponse<>(200,"sucess",authenticationService.authenticate(request));
        }catch(Exception e){
            return new GenericResponse<>(406,"error",authenticationService.authenticate(request));
        }
    }
}
