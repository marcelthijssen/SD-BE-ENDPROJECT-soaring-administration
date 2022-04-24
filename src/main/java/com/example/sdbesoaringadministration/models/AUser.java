package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ausers")
public class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
            private Long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    //     added
    private boolean enabled = false;

    @ManyToMany
    @JoinTable(
            name = "ausers_roles",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "ausers_id"))
    private Set<Role> roles = new HashSet<>();

    //
    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    //    added
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles( Set<Role> roles ) {
    }
}