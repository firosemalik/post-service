package com.social.post.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PostRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String message;

    @NotEmpty
    private List<@Valid TagRequest> tags;

}
