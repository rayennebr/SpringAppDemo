package com.demo.SpringSecurityTest.Authentication.auth;

import com.demo.SpringSecurityTest.Authentication.response.AuthenticationResponse;
import com.demo.SpringSecurityTest.Authentication.config.JwtService;
import com.demo.SpringSecurityTest.Authentication.repositories.UserRepository;
import com.demo.SpringSecurityTest.Authentication.entites.Role;
import com.demo.SpringSecurityTest.Authentication.entites.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        if(request.getRole().equals("admin"))
        {
            user.setRole(Role.ADMIN);
        }else if(request.getRole().equals("user"))
        {
            user.setRole(Role.USER);
        }else
        {
            user.setRole(Role.UNKNOWN);
        }
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        //user.setToken(jwtToken);
        //userRepository.save(user);
        return AuthenticationResponse.builder().data(user)
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        user.setToken(jwtToken);
        userRepository.saveAndFlush(user);
        return AuthenticationResponse.builder()
                .data(user)
                .token(jwtToken)
                .build();
    }
}
