package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users_has_roles")
public class UsersHasRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JoinedTableID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_user_id", nullable = false)
    private User usersUser;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roles_role_name", nullable = false)
    private Role rolesRoleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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