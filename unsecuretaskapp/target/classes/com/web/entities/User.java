package com.web.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="ldap")
    private String ldap;

    @Column(name="password")
    private String password;

    @ManyToMany(mappedBy = "projectManagers")
    private Set<Project> projects;

//    @JsonBackReference(value = "project_manager_project")
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectManager")
//    private List<ProjectManage> projectManages;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Task> tasks;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

//    @ManyToOne
//    @JoinColumn(name="role_id", referencedColumnName = "id")
//    private Role role;

}
