package com.demo.SpringSecurityTest.Authentication.response;

import com.demo.SpringSecurityTest.Authentication.entites.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse{
    private User data;
    private String token;
}
