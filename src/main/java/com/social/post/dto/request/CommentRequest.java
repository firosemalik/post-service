package com.social.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {

    @NotNull
    private Long commentId;

    @NotBlank
    private String commentText;

    @NotNull
    private Long postId;
}
