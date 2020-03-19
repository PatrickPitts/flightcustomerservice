package org.nerdcore.flightcustomerservice.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserAuthorityId implements Serializable {

    private String username;
    private String authority;

    public UserAuthorityId(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public UserAuthorityId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthorityId)) return false;
        UserAuthorityId that = (UserAuthorityId) o;
        return username.equals(that.username) &&
                authority.equals(that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }
}
