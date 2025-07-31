package com.social.post.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Like implements Serializable {

    //TODO : Equals can check only id

    @Id
    @GeneratedValue
    private Long likeId;

    private ZonedDateTime dateTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private LikeType type;

    @PrePersist
    @PreUpdate
    private void validateLike() {
        if (post == null && comment == null) {
            throw new IllegalStateException("Like must be associated with a post or a comment");
        }
    }


}
