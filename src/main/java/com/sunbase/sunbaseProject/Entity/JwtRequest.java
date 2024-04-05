package com.sunbase.sunbaseProject.Entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class JwtRequest {
    // The email associated with the authentication request.
    private String email;

    // The password associated with the authentication request.
    private String password;
}
