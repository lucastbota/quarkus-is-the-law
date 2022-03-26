package tech.donau.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "users")
@UserDefinition
public class User extends PanacheEntity {
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static void add(String username, String password, String role) {
        User u = new User();
        u.username = username;
        u.password = BcryptUtil.bcryptHash(password);
        u.role = role;
        u.persist();
    }
}
