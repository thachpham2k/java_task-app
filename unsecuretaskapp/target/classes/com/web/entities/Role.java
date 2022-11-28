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
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="detail")
    private String detail;

    @ManyToMany(mappedBy="roles")
    private Set<User> users;
//    @JsonBackReference
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
//    private List<User> users;
}
