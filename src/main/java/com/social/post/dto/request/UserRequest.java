package com.social.post.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;
}
