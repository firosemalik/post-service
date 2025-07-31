package com.social.post.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Like {

    @NotNull
    private Long likeId;

    @NotNull
    private Long referenceId;

    @Valid
    private LikeType type;

}
