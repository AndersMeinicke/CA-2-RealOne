package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsersHasRoleId implements Serializable {
    private static final long serialVersionUID = -1674986501871503921L;
    @NotNull
    @Column(name = "users_user_id", nullable = false)
    private Integer usersUserId;

    @Size(max = 20)
    @NotNull
    @Column(name = "roles_role_name", nullable = false, length = 20)
    private String rolesRoleName;

    public Integer getUsersUserId() {
        return usersUserId;
    }

    public void setUsersUserId(Integer usersUserId) {
        this.usersUserId = usersUserId;
    }

    public String getRolesRoleName() {
        return rolesRoleName;
    }

    public void setRolesRoleName(String rolesRoleName) {
        this.rolesRoleName = rolesRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersHasRoleId entity = (UsersHasRoleId) o;
        return Objects.equals(this.usersUserId, entity.usersUserId) &&
                Objects.equals(this.rolesRoleName, entity.rolesRoleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersUserId, rolesRoleName);
    }

}