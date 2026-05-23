package com.unal.andromeda.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cedula;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = true)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_enterprise", referencedColumnName = "id", nullable = true)
    private Enterprise enterprise;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profile", referencedColumnName = "id", nullable = true)
    private Profile profile;
}
