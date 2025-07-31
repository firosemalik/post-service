package com.social.post.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long userId;

    private String name;

    private String email;

    private String password;

    private Date dob;

    //classic case of self referencing
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends = new ArrayList<>();

    public void addFriend(User friend) {
        if (friend == null || friend.equals(this)) return;
        if (!friends.contains(friend)) {
            friends.add(friend);
            friend.friends.add(this); // mutual friendship
        }
    }

    public void removeFriend(User friend) {
        if (friend == null) return;
        if (friends.contains(friend)) {
            friends.remove(friend);
            friend.friends.remove(this); // remove from both sides
        }
    }
}
