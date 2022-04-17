package com.github.sedevelopment.sebanking.models.role;

import javax.persistence.*;

@Entity
@Table(name="app_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String roleName;

    public Role(){}

    public Role(String roleName) {
        super();
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
