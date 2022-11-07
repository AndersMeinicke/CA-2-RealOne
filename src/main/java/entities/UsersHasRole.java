package entities;

import javax.persistence.*;

@Entity
@Table(name = "users_has_roles")
public class UsersHasRole {
    @EmbeddedId
    private UsersHasRoleId id;

    @MapsId("usersUserId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_user_id", nullable = false)
    private User usersUser;

    @MapsId("rolesRoleName")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roles_role_name", nullable = false)
    private Role rolesRoleName;

    public UsersHasRoleId getId() {
        return id;
    }

    public void setId(UsersHasRoleId id) {
        this.id = id;
    }

    public User getUsersUser() {
        return usersUser;
    }

    public void setUsersUser(User usersUser) {
        this.usersUser = usersUser;
    }

    public Role getRolesRoleName() {
        return rolesRoleName;
    }

    public void setRolesRoleName(Role rolesRoleName) {
        this.rolesRoleName = rolesRoleName;
    }

}