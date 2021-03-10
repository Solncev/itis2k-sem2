package com.solncev.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @NotBlank(message = "Name shouldn't be blank!")
    @Size(max = 64, message = "Max name size: 64")
    @Column(length = 64, nullable = false)
    private String name;

    @NotBlank(message = "Lastname shouldn't be  blank")
    @Size(max = 64, message = "Max lastname size: 64")
    @Column(length = 64)
    private String lastname;

    @NotBlank(message = "Email shouldn't be blank!")
    @Size(min = 5, max = 100, message = "")
    @Column(nullable = false, length = 100)
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 8, max = 64, message = "Password should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String password;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(mappedBy = "owner")
    private List<Gadget> gadgets;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
    )
    private List<Group> groups;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
