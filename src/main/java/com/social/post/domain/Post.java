package com.social.post.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long postId;

    private ZonedDateTime dateTime;

    private String message;

    //TODO BatchSize or EntityGrpah or Query should be used to avoid n+1 here al loadPost method level
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Like> likes = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
