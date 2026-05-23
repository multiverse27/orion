package com.unal.andromeda.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enterprises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private String name;
}
