package org.nerdcore.flightcustomerservice.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(UserAuthorityId.class)
@Table(name="UserAuthority")
public class UserAuthority implements Serializable {

    @Id
    private String username;

    @Id
    private String authority;

    public UserAuthority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public UserAuthority() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthority)) return false;
        UserAuthority that = (UserAuthority) o;
        return username.equals(that.username) &&
                authority.equals(that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, authority);
    }
}
