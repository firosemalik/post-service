package com.social.post.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TagRequest {
    @NotNull
    private TagType type;

    @NotEmpty
    private List<@NotNull Long> ids;
}
